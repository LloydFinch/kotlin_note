package mooc_demo.face_object;

public class TestJ {

    public static void main(String[] args) {
        //调用kotlin的扩展函数
        String hello = ExtendsKt.mutiply("hello", 10);
        System.out.println(hello);

    }
}
