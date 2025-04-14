import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CanStack {
    private final int capacity = 5;
    private final Can[] stack = new Can[capacity];
    private int top = -1;

    public void push(Can can) {
        if (!isFull()) {
            stack[++top] = can;
        }
    }

    public Can pop() {
        return isEmpty() ? null : stack[top--];
    }

    public Can peek() {
        return isEmpty() ? null : stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}