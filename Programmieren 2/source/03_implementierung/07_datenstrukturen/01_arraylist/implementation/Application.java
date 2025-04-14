public class Application {
    public static void main(String... args) {
        Rental rental = new Rental();
        rental.rentCar(3);
        rental.rentCar(5);
        rental.rentCar(3);
        rental.returnCar(3);
    }
}