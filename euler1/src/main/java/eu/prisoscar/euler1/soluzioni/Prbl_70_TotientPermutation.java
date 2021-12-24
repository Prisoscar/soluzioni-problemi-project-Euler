package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Divisors;
import eu.prisoscar.euler1.algoritmi_trasversali.NumberPatterns;
import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

public class Prbl_70_TotientPermutation {

    private static final long TARGET = 10_000_000L;

    //https://en.wikipedia.org/wiki/Euler's_totient_function
    //using Euler's product formula
    public static long getSolution() {
        long solution = 1;
        double lastSmallerRatio = 100D;
        long phiN;
        for (long i = 2; i <= TARGET; i++){
            phiN = ((Double)Divisors.getPrimeFactorsList(i).stream()
                    .filter(PrimeNumbers::isPrime)
                    .mapToDouble(d -> ((double)d))
                    .reduce(i, (subtotal, actualValue) -> subtotal *= ( 1 - 1 / actualValue))
            ).longValue();
            if (!NumberPatterns.arePermutations(i, phiN)) continue;
            double ratio = (double)i / phiN;
            if (ratio < lastSmallerRatio) {
                lastSmallerRatio = ratio;
                solution = i;
            }
        }
        return solution;
    }
}
