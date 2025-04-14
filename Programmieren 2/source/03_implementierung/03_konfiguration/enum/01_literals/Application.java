import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        TrafficLight trafficLight = new TrafficLight();
        for (int i = 0; i < 4; i++, trafficLight.change()) log.info("{}", trafficLight);
    }
}