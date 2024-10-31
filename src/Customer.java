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