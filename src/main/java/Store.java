public class Store {

    public static final int THREAD_SLEEP_TIME = 1000;
    public static final int ASSEMBLY_TIME = 500;
    public static final int MAX_DELIVERY = 1;
    public static final int MIN_FOR_SALE = 1;
    private int car;


    public synchronized void buyCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в салон.");
            while (car < MIN_FOR_SALE) {
                System.out.println("Салон пустой. Ждите");
                wait();
            }
        } catch (InterruptedException e) {
        }
        try {
            Thread.sleep(THREAD_SLEEP_TIME);
            car--;
            System.out.println(Thread.currentThread().getName() + " Уехал на Opel Astra.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Товаров на складе: " + car);
        notifyAll();
    }


    public synchronized void putCar() {
        try {
            while (car >= MAX_DELIVERY) {
                wait();

            }
        } catch (InterruptedException e) {
        }

        try {
            car++;
            System.out.println("Производитель Opel привез 1 автомобиль");
            Thread.sleep(ASSEMBLY_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Товаров на складе: " + car);
        notify();
    }
}

