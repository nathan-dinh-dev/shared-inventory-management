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