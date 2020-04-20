
public class TestNewJ {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {

            @Override
            public void run() {
                System.out.println("head of thread run");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("trail of  thread run");
            }
        };

        thread.start();

        System.out.println("before suspend");
        Thread.sleep(1000);
        //线程挂起
        thread.suspend();
        System.out.println("after suspend, before resume");
        Thread.sleep(3000);
        //线程恢复
        thread.resume();
        System.out.println("after resume");

    }

    public static void testStrTraversal() {
        String str = "hello";
    }
}
