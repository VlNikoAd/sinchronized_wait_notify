public class Consumer implements Runnable {

    Store store;
    public static final int WAITING_TIME = 1000;
    public static final int CARS = 5;

    public Consumer(Store store) {
        this.store = store;

    }

    public void run() {

        for (int i = 1; i < CARS; i++) {
            try {
                Thread.sleep(WAITING_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            store.buyCar();
        }
    }
}