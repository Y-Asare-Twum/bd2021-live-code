package org.example.java11.slides.h11;

public class EnclosingClass {

    public String field;
    public static String someStatic;

    public void method() {
        this.field = "Cool";
    }

    public static class StaticNestedClass {

    }

    public class InnerClass {
        // this; // my own this
        String ecfield = EnclosingClass.this.field; // EnclosingClass's this
        // ....

        public class InnerInnerClass {

        }

    }
}

class App {
    public static void main(String[] args) {
        EnclosingClass ec = new EnclosingClass();

        // aanroepen van members via object van EnclosingClass:
        String f = ec.field;
        ec.method();
        EnclosingClass.InnerClass ic = ec.new InnerClass();

        String someStatic = EnclosingClass.someStatic;

        EnclosingClass.StaticNestedClass snc = new EnclosingClass.StaticNestedClass();
        BehavesLikeStaticNestedClass snc2 = new BehavesLikeStaticNestedClass();
    }
}
