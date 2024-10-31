/**
 * Supplier class representing a supplier thread that adds items to the inventory.
 * A Supplier continuously tries to add a specified quantity of items to the shared inventory
 * managed by an InventoryManager instance. If the inventory reaches its maximum capacity, it
 * will wait until there is space available, ensuring thread safety and proper resource management.
 *
 * Programmed by Nathan Dinh
 * Date: 10/31/2024
 */
class Supplier extends Thread {
    private final InventoryManager manager;
    private final int quantity;

    public Supplier(InventoryManager manager, int quantity) {
        this.manager = manager;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        try {
            while (true) {
                manager.addItem(quantity);
                Thread.sleep(1000); // Simulating delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
