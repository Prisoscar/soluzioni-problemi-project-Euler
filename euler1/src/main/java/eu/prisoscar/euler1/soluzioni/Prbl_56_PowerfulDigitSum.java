package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Operations;

import java.math.BigInteger;

/*
A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost unimaginably large:
one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.

Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 */
public class Prbl_56_PowerfulDigitSum {

    private static final int TARGET = 100;

    public static long getSolution(){
        long solution = 0;
        for (int a = 1; a < TARGET; a++){
            for (int b = 1; b < TARGET; b++){
                long digitSum = Operations.digitsSum(new BigInteger(String.valueOf(a)).pow(b));
                if (digitSum > solution) solution = digitSum;
            }
        }
        return solution;
    }
}
