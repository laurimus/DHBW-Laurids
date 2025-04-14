import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Burger {
    private final Topic[] topics;
    private final int capacity;
    private int top = -1;

    public Burger(int size) {
        this.capacity = size;
        topics = new Topic[size];
    }

    public void push(Topic topic) {
        if (top >= capacity - 1) {
            log.info("stack overflow");
            return;
        }
        topics[++top] = topic;
        log.info("{} pushed to stack", topic);
    }

    public Topic pop() {
        return (top < 0) ? logAndReturnNull() : topics[top--];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    private Topic logAndReturnNull() {
        log.info("stack underflow");
        return null;
    }
}