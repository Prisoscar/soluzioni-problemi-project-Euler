package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Operations;

import java.math.BigInteger;

/*
There are exactly ten ways of selecting three from five, 12345:

123, 124, 125, 134, 135, 145, 234, 235, 245, and 345

In combinatorics, we use the notation,

.

In general,
, where , , and

.

It is not until
, that a value exceeds one-million:

.

How many, not necessarily distinct, values of
for , are greater than one-million?
 */
public class Prbl_53_CombinatoricSelections {

    private static final int START_RANGE = 23;
    private static final int END_RANGE = 100;
    private static final BigInteger TARGET = new BigInteger("1000000");

    public static int getSolution(){
        int solution = 0;
        for (int n = START_RANGE; n <= END_RANGE; n++){
            for (int r = 0; r <= n; r++){
                if (Operations.factorial(n).divide(Operations.factorial(r).multiply(Operations.factorial(n - r))).compareTo(TARGET) > 0) solution++;
            }
        }
        return solution;
    }
}
