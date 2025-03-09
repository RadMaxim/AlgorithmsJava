package org.example.Bulean;

public class FastExponentiation {

    public static long power(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent/=2;

        }
        return result;
    }

    public static void main(String[] args) {
        long base = 2;
        long exponent = 10;
        long result = power(base, exponent);
//        long res1 = getNumber(base, exponent);
        System.out.println(base + "^" + exponent + " = " + result);
//        System.out.println(base + "^" + exponent + " = " + result);
    }
    public static long getNumber(long base, long exponent){
        int buf = 1;
        int count = 0 ;
        while (exponent>0){
            exponent--;
            buf*=base;
            count++;
        }
        System.out.println(count);
        return buf;
    }
}
