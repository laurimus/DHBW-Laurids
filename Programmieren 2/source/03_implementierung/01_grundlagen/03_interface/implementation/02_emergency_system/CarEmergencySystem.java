import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

@Slf4j
@Getter
public class CarEmergencySystem implements IEmergencySystem {
    private final String carModel;
    private final String licensePlate;
    private final Map<EmergencyType, Runnable> emergencyHandlers = new EnumMap<>(EmergencyType.class);
    private LocalDateTime timeOfEmergency;

    public CarEmergencySystem(String carModel, String licensePlate) {
        this.carModel = carModel;
        this.licensePlate = licensePlate;
        initializeEmergencyHandlers();
    }

    public void handleEmergency(EmergencyType emergencyType) {
        Runnable handler = emergencyHandlers.get(emergencyType);
        if (handler != null) {
            handler.run();
        } else {
            log.warn("no handler found for emergency type: {}", emergencyType);
        }
    }

    private void handleTireFailure() {
        timeOfEmergency = LocalDateTime.now();
        log.error("emergency: tire failure detected in car model {} with license plate {} at {}", carModel, licensePlate, timeOfEmergency);
        displayEmergencyMessage("tire failure");
    }

    private void handleEngineFailure() {
        timeOfEmergency = LocalDateTime.now();
        log.error("emergency: engine failure detected in car model {} with license plate {} at {}", carModel, licensePlate, timeOfEmergency);
        displayEmergencyMessage("engine failure");
    }

    private void handleAccident() {
        timeOfEmergency = LocalDateTime.now();
        log.error("emergency: accident detected in car model {} with license plate {} at {}", carModel, licensePlate, timeOfEmergency);
        displayEmergencyMessage("accident");
    }

    private void handleLowFuel() {
        timeOfEmergency = LocalDateTime.now();
        log.warn("warning: low fuel detected in car model {} with license plate {} at {}", carModel, licensePlate, timeOfEmergency);
        displayEmergencyMessage("low fuel");
    }

    private void initializeEmergencyHandlers() {
        emergencyHandlers.put(EmergencyType.TIRE_FAILURE, this::handleTireFailure);
        emergencyHandlers.put(EmergencyType.ENGINE_FAILURE, this::handleEngineFailure);
        emergencyHandlers.put(EmergencyType.ACCIDENT, this::handleAccident);
        emergencyHandlers.put(EmergencyType.LOW_FUEL, this::handleLowFuel);
    }

    private void displayEmergencyMessage(String message) {
        String emergencyMessage = String.format("emergency alert for %s (%s): %s time: %s", carModel, licensePlate, message, timeOfEmergency);
        log.info(emergencyMessage);
    }
}