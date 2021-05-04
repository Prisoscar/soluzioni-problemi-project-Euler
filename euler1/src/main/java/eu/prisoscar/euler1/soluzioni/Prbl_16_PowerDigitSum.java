package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;

/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
 */
public class Prbl_16_PowerDigitSum {

    private static final int EXPONENT = 1000;

    public static int getSolution(){
        int solution = 0;
        String resultString = new BigInteger("2").pow(EXPONENT).toString();
        for (int i = 0; i < resultString.length(); i++){
            solution += Character.getNumericValue(resultString.charAt(i));
        }
        return solution;
    }
}
