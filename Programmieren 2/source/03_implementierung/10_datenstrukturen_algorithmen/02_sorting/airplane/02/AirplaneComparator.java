import java.util.Comparator;

public class AirplaneComparator {
    public static final Comparator<Airplane> COMPLEX_COMPARATOR =
            Comparator.comparing((Airplane a) -> a.getCarrier().name())
                    .thenComparing(Comparator.comparing(Airplane::getManufacturingDate).reversed())
                    .thenComparingLong(Airplane::getSerialNumber)
                    .thenComparing(Airplane::getRegistrationID);
}