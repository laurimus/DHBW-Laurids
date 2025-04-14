import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

@Slf4j
public class Application {
    public static final Comparator<Customer> ID_COMPARATOR = Comparator.comparingInt(Customer::getId);

    public static void addCustomersToQueue(Queue<Customer> customerPriorityQueue) {
        customerPriorityQueue.add(new Customer(4, "Ayden Coates"));
        customerPriorityQueue.add(new Customer(1, "Kendra Hunt"));
        customerPriorityQueue.add(new Customer(2, "Elwood Maxwell"));
        customerPriorityQueue.add(new Customer(8, "Kean Emery"));
        customerPriorityQueue.add(new Customer(3, "Kathy Sullivan"));
        customerPriorityQueue.add(new Customer(7, "Bentley Knox"));
        customerPriorityQueue.add(new Customer(6, "Noa Young"));
        customerPriorityQueue.add(new Customer(5, "Isaak Harrison"));

        log.info("customers added to queue.");
    }

    public static void processCustomers(Queue<Customer> customerPriorityQueue) {
        Customer customer;
        while ((customer = customerPriorityQueue.poll()) != null) {
            log.info("processing customer: {}", customer);
        }

        log.info("all customers processed.");
    }

    public static void main(String... args) {
        Queue<Customer> customerPriorityQueue = new PriorityQueue<>(7, ID_COMPARATOR);
        addCustomersToQueue(customerPriorityQueue);
        processCustomers(customerPriorityQueue);
    }
}