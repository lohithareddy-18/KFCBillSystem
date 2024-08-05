import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Customer {
    private static int idCounter = 0;
    private int tokenNumber;
    private String order;
    private double price;

    public Customer(String order, double price) {
        this.tokenNumber = ++idCounter;
        this.order = order;
        this.price = price;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public String getOrder() {
        return order;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Token #" + tokenNumber + ": Order: " + order + " | Price: $" + price;
    }
}

class BillingCounter extends Thread {
    private Queue<Customer> queue;
    private int counterNumber;

    public BillingCounter(int counterNumber) {
        this.queue = new LinkedList<>();
        this.counterNumber = counterNumber;
    }

    public synchronized void addCustomer(Customer customer) {
        queue.add(customer);
        notify();
    }

    private synchronized Customer getNextCustomer() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Customer customer = getNextCustomer();
                System.out.println("Counter " + counterNumber + " is processing " + customer);
                Thread.sleep(2000); // Simulating time to process an order
                System.out.println("Counter " + counterNumber + " finished processing " + customer);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class KFC {
    private static Scanner scanner = new Scanner(System.in);
    private static BillingCounter[] counters = new BillingCounter[3];

    public static void main(String[] args) {
        for (int i = 0; i < counters.length; i++) {
            counters[i] = new BillingCounter(i + 1);
            counters[i].start();
        }

        while (true) {
            System.out.println("KFC Menu:");
            System.out.println("1. Chicken Bucket - $10.99");
            System.out.println("2. Burger - $5.99");
            System.out.println("3. Fries - $2.99");
            System.out.println("4. Exit");

            System.out.print("Place your order (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 4) {
                System.out.println("Thank you for visiting KFC!");
                System.exit(0);
            }

            String order = "";
            double price = 0.0;
            switch (choice) {
                case 1:
                    order = "Chicken Bucket";
                    price = 10.99;
                    break;
                case 2:
                    order = "Burger";
                    price = 5.99;
                    break;
                case 3:
                    order = "Fries";
                    price = 2.99;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    continue;
            }

            Customer customer = new Customer(order, price);
            System.out.println("Your token number is: " + customer.getTokenNumber());
            System.out.println("Please wait while your order is being processed.");

            int counterIndex = customer.getTokenNumber() % 3;
            counters[counterIndex].addCustomer(customer);
        }
    }
}
