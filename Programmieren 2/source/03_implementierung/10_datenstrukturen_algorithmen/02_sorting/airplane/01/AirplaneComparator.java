import java.util.Comparator;

public class AirplaneComparator {
    public static final Comparator<Airplane> BySerialNumber = Comparator.comparingLong(Airplane::getSerialNumber);

    public static final Comparator<Airplane> ByRegistrationID = Comparator.comparing(Airplane::getRegistrationID);

    public static final Comparator<Airplane> ByManufacturingDate = (a1, a2) -> a2.getManufacturingDate().compareTo(a1.getManufacturingDate());

    public static final Comparator<Airplane> ByCarrier = Comparator.comparing(a -> a.getCarrier().name());
}