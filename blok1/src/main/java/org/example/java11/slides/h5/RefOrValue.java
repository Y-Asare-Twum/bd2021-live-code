package org.example.java11.slides.h5;

public class RefOrValue {

    public static void main(String[] args) {
        RefOrValue refOrValue = new RefOrValue();

        int k = 6;
        refOrValue.addOne(k);
        System.out.println(k);

        // Integer i = 6; // auto boxing
        Integer i = Integer.valueOf(6); // i@123, manual boxing
        refOrValue.addOne(i);
        System.out.println(i); // i still @123

        MutableInteger m = new MutableInteger(6);
        refOrValue.addOne(m);
        System.out.println(m.getValue());

        refOrValue.printFromIToZero(5);
    }

    public void addOne(int x) {
        x++; // increment _local_ variable x
    }

    public void addOne(Integer x) { // x@123
        int unboxedX = x.intValue();
        Integer newXPlusOne = Integer.valueOf(unboxedX + 1); // newXPlusOne@456
        x = newXPlusOne; // x@456 (but x is local!)
    }

    public void addOne(MutableInteger x) { // x@123
        x.inc(); // modify contents of x
    }

    public void printFromIToZero(int i) {
        if (i < 0) return;      // stop condition

        System.out.println(i);  // action

        printFromIToZero(i - 1);// recursion
    }

}
