
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InventoryManager {
    private int inventory = 0;
    private final int MAX_INVENTORY;

    // Lock and condition variables for suppliers and customers
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public InventoryManager(int maxInventory) {
        this.MAX_INVENTORY = maxInventory;
    }

    // Supplier method to add items to inventory
    public void addItem(int quantity) throws InterruptedException {
        lock.lock();
        try {
            // Wait until there is space available
            while (inventory + quantity > MAX_INVENTORY) {
                notFull.await();
            }
            inventory += quantity;
            System.out.println("Added " + quantity + " items. Inventory: " + inventory);
            // Signal that items are available for customers
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    // Customer method to remove items from inventory
    public void removeItem(int quantity) throws InterruptedException {
        lock.lock();
        try {
            // Wait until there are enough items available
            while (inventory < quantity) {
                notEmpty.await();
            }
            inventory -= quantity;
            System.out.println("Removed " + quantity + " items. Inventory: " + inventory);
            // Signal that space is available for suppliers
            notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }
}