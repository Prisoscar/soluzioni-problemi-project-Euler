package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;

/*
It is possible to show that the square root of two can be expressed as an infinite continued fraction.

By expanding this for the first four iterations, we get:

The next three expansions are
,
, and
, but the eighth expansion,

, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.

In the first one-thousand expansions, how many fractions contain a numerator with more digits than the denominator?
 */
public class Prbl_57_SquareRootConvergents {

    private static final int TARGET = 1000;

    /*
    actual fraction can be determined from last one with this algorithm:
    defining golden number = last numerator + last denominator, we can obtain
                      golden number + last denominator
    actual fraction = ________________________________
                      golden number
    or else
    actual nominator = last nominator + 2 * last denominator
    actual denominator = last nominator + last denominator
     */
    public static int getSolution(){
        int solution = 0;
        //starting from 1st iteration (3/2)
        BigInteger lastNumerator = new BigInteger("3");
        BigInteger lastDenominator = new BigInteger("2");
        BigInteger actualNumerator, actualDenominator;
        for(int i = 1; i < TARGET; i++){
            actualNumerator = lastNumerator.add(lastDenominator.multiply(new BigInteger("2")));
            actualDenominator = lastDenominator.add(lastNumerator);
            if (String.valueOf(actualNumerator).length() > String.valueOf(actualDenominator).length()) solution++;
            lastNumerator = actualNumerator;
            lastDenominator = actualDenominator;
        }
        return solution;
    }
}
