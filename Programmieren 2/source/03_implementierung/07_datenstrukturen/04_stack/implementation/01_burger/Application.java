import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Application {
    public static void main(String... args) {
        Burger burger = new Burger(6);
        String[][] ingredients = {{"bun", "bread for the burger"}, {"patty", "beef patty"}, {"lettuce", "fresh lettuce leaves"}, {"cheese", "cheddar cheese slice"}, {"tomato", "fresh tomato slices"}, {"bun", "bread for the burger"}};
        Arrays.stream(ingredients).map(ing -> new Topic(ing[0], ing[1])).forEach(burger::push);

        log.info("---");

        while (!burger.isEmpty()) {
            log.info(burger.pop().toString());
        }
    }
}