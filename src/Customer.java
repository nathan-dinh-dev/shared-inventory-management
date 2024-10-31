/**
 * Customer class representing a customer thread that removes items from the inventory.
 * A Customer continuously tries to remove a specified quantity of items from the shared inventory
 * managed by an InventoryManager instance. If the inventory is insufficient, it will wait until
 * items are available, ensuring thread safety and proper resource handling.
 *
 * Programmed by Nathan Dinh
 * Date: 10/31/2024
 */
// Customer thread class
class Customer extends Thread {
    private final InventoryManager manager;
    private final int quantity;

    public Customer(InventoryManager manager, int quantity) {
        this.manager = manager;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        try {
            while (true) {
                manager.removeItem(quantity);
                Thread.sleep(1500); // Simulating delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}