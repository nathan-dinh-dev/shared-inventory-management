// Supplier thread class
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
