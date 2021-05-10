package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;

/*
The Fibonacci sequence is defined by the recurrence relation:

    Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.

Hence the first 12 terms will be:

    F1 = 1
    F2 = 1
    F3 = 2
    F4 = 3
    F5 = 5
    F6 = 8
    F7 = 13
    F8 = 21
    F9 = 34
    F10 = 55
    F11 = 89
    F12 = 144

The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Prbl_25_1000DigitsFibonacciNumber {

    private static final int TARGET = 1000;

    public static int getSolution(){
        int solution = 2;
        BigInteger lastFibonacciNumber = new BigInteger("1");
        BigInteger currentFibonacciNumber = new BigInteger("1");
        BigInteger auxiliaryVariable;
        while (currentFibonacciNumber.toString().length() < TARGET){
            auxiliaryVariable= currentFibonacciNumber;
            currentFibonacciNumber = currentFibonacciNumber.add(lastFibonacciNumber);
            lastFibonacciNumber = auxiliaryVariable;
            solution++;
        }
        return solution;
    }
}
