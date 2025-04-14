import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        ShoppingCenter shoppingCenter = new ShoppingCenter("Bad Mergentheim", 10);

        Car car01 = new Car("UI7HZBGMJUB", "ABC");
        shoppingCenter.park(6, car01);

        Car car02 = new Car("JU7NH6KUINB", "XYZ");
        shoppingCenter.park(1, car02);

        Car car03 = new Car("KUJ7UNH6KIB", "ABC");
        shoppingCenter.park(3, car03);
        log.info("---");

        shoppingCenter.report();
        log.info("---");

        shoppingCenter.freeParkingPosition(6);
        log.info("---");

        shoppingCenter.report();
    }
}