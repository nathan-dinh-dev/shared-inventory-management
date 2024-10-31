/**
 * InventorySystem is the main class that sets up and runs the shared inventory management system.
 * It initializes an InventoryManager with a maximum capacity, creates supplier and customer threads,
 * and starts them to simulate real-world supplier and customer interactions with the inventory.
 *
 * Programmed by Nathan Dinh
 * Date: 10/31/2024
 */
// Main class to execute the system
public class InventorySystem {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager(10); // Set max inventory limit

        // Create supplier and customer threads
        Supplier supplier1 = new Supplier(manager, 3);
        Customer customer1 = new Customer(manager, 2);
        Customer customer2 = new Customer(manager, 4);

        // Start the threads
        supplier1.start();
        customer1.start();
        customer2.start();
    }
}