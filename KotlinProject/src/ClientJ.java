import java.util.concurrent.atomic.AtomicInteger;

public class ClientJ {

    private static int number = 0;

    private static AtomicInteger integer = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("size:" + Thread.activeCount());
        System.out.println("thread:" + Thread.currentThread());

        //test();
        //test2();

        Super child2 = new Child2();
        child2.hello();
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

    static class Super {
        protected int a = 10;

        protected void hello() {
            System.out.print("supper: " + a);
        }
    }

    static class Child2 extends Super {

        protected int a = 20;

        @Override
        protected void hello() {
            System.out.print("child2: " + a);
        }
    }


    interface A {
        void hello();
    }

    interface B {
        void hello();
    }

    class C implements A, B {

        @Override
        public void hello() {
            //TODO A 的还是 B 的
        }
    }
}
