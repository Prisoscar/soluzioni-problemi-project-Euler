package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;

/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */
public class Prbl_20_FactorialDigitSum {

    private static final int TARGET = 100;

    public static int getSolution(){
        int solution = 0;
        BigInteger factorialSolution = new BigInteger("1");
        String factorialSolutionString;
        for (int i = TARGET; i > 1; i--){
            factorialSolution = factorialSolution.multiply(new BigInteger(String.valueOf(i)));
        }
        factorialSolutionString = factorialSolution.toString();
        for (int i = 0; i <factorialSolutionString.length(); i++){
            solution += Integer.parseInt(factorialSolutionString.substring(i, i + 1));
        }
        return solution;
    }
}
