package jbyte;

public class Hello {

    public static void main(String[] args) {
        System.out.println("hello, world");
        testTypeLength();
    }

    public static void testTypeLength() {
        System.out.println("char size: " + Character.SIZE);

        System.out.println("int size: " + Integer.SIZE);
    }
}