import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        Airplane airplane = new Airplane();

        airplane.reserveSeat("10B");
        airplane.reserveSeat("15C");
        airplane.reserveSeat("25F");
        airplane.reserveSeat("30A");
        airplane.reserveSeat("30A");
        log.info("---");

        airplane.printSeating();
        log.info("---");

        airplane.cancelReservation("15C");
        airplane.cancelReservation("20D");
        log.info("---");

        airplane.printSeating();
    }
}