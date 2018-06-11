import java.util.concurrent.atomic.AtomicInteger;

public class Client {

    private static int number = 0;

    private static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("size:" + Thread.activeCount());
        System.out.println("thread:" + Thread.currentThread());

        //test();
        test2();
    }

    private static void increase() {
        //number++;
        integer.incrementAndGet();
    }

    public static void test() {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    increase();
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.printf("number=%d", number);
    }

    public static void test2() {
        Math.round(1);
        int a = -1;
        int b = a >> 4;
        System.out.print(b);
    }
}
