package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.List;

/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */
public class Prbl_10_SummationOfPrimes {

    private static final int TARGET = 2_000_000;

    public static long getSolution(){
        long solution;
        List<Long> primesList = PrimeNumbers.findPrimes(TARGET);
        solution = primesList.stream().reduce(0L, Long::sum);
        return solution;
    }
}
