package firstlinecode;

/**
 * Name: TestFirstLineCode
 * Author: lloydfinch
 * Function: TestFirstLineCode
 * Date: 2020-04-21 18:25
 * Modify: lloydfinch 2020-04-21 18:25
 */
public class TestFirstLineCode {
    public static void main(String[] args) {
        Utils.Companion.doAction();

        //添加了@JvmStatic注解，可以直接当作static方法调用
        Utils.doAction2();

        //顶层方法会编译成一个nameKt类
        ToolsKt.doAction3();


        test();
    }


    private static void testNullCast(Number number) {

        Integer integer = (Integer) number;

        System.out.println(integer);
    }

    private static void test() {
        Integer integer = null;
        testNullCast(integer);
    }
}
