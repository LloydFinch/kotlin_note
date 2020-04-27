import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class Test {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        String result = TExport.Companion.combineToString(a, b, integer -> integer1 -> "a * b = " + a * b);
        System.out.println("result: " + result);

        try {
            testReflection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Math.hypot(-3, 4));
    }


    private static void testReflection() throws Exception {
        Fuck fuck = new Fuck();
        Method fuck1 = fuck.getClass().getMethod("fuck1");
        fuck1.invoke(fuck);

        Method fuck2 = fuck.getClass().getMethod("fuck2", String.class);
        fuck2.invoke(fuck, "fuck");
    }

    static class Fuck {
        public String name;

        public void fuck1() {
            System.out.println("this is fuck1");
        }

        public void fuck2(String message) {
            System.out.println("this is fuck2: " + message);
        }

        private volatile Object object = new Object();
    }


    private static void test() {
    }
}
