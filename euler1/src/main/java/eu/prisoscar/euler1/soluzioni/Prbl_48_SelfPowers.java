package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;

/*
The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Prbl_48_SelfPowers {

    private static final int TARGET = 1_000;

    public static String getSolution(){
        String solution = "1";
        for (int i = 2; i <= TARGET; i++){
            solution = new BigInteger(String.valueOf(i)).pow(i).add(new BigInteger(solution)).toString();
        }
        return solution.substring(solution.length() - 10);
    }
}
