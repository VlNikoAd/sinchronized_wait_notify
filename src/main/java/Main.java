public class Main {

    static final Store store = new Store(10);

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (store) {
                for (int i = 0; i < store.capacity; i++) {
                    store.makeCar();
                    store.notify();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (store) {
                for (int i = 0; i < store.capacity; i++) {
                    System.out.println("Заходит покупатель...");
                    synchronized (store) {
                        if (!store.car.isEmpty()) {
                            System.out.println("Купили" + store.car.remove(0));
                        } else {
                            try {
                                System.out.println("Машин нету...");
                                store.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }).start();

    }
}
