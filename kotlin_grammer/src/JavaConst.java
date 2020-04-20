public class JavaConst {

    public static void main(String[] args) {
        System.out.println();

        try {
            //会初始化
//            Class.forName(Const.class.getName());

            //不会初始化类
            ClassLoader.getSystemClassLoader().loadClass(Const.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Const {
        public static final long a = 10;

        static {
            System.out.println("init Const");
        }
    }
}
