public class Application {
    public static void main(String... args) {
        Book book = new Book("Learning Java", "John Doe", 5);
        book.displayContent();
        book.displayPageContent(3);
        book.displayPageContent(6);
    }
}