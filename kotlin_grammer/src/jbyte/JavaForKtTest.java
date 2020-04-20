package jbyte;

import java.util.ArrayList;
import java.util.List;

public class JavaForKtTest {
    public static void main(String[] args) {

        Integer[] ints = {};

        Number[] numbers = ints;

    }

    public static void testGere() {
        List<? extends Child> children = new ArrayList<>();
        Child child = children.get(0);
//        List<Sun> suns = new ArrayList<>();
//        children = suns;

        List<? super Child> chil = new ArrayList<>();
        chil.add(new Child());
        chil.add(new Sun());
    }

    public static class Parent {

    }

    public static class Child extends Parent {

    }

    public static class Sun extends Child {

    }
}
