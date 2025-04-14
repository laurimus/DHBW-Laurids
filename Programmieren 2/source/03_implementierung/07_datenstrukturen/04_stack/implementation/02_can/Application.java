import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application {
    public static void main(String... args) {
        CanStack warehouseStack = new CanStack();

        warehouseStack.push(new Can("Tomato Soup", 0.5));
        warehouseStack.push(new Can("Baked Beans", 0.4));
        warehouseStack.push(new Can("Corn", 0.45));
        warehouseStack.push(new Can("Peas", 0.35));
        warehouseStack.push(new Can("Mushroom Soup", 0.5));

        log.info("top can in stack : {}", warehouseStack.peek());
        log.info("removing         : {}", warehouseStack.pop());
        log.info("new top can      : {}", warehouseStack.peek());
    }
}