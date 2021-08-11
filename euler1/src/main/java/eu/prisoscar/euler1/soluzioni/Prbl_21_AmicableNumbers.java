package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Divisors;

/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */
public class Prbl_21_AmicableNumbers {

    private static final int TARGET = 10_000;

    public static int getSolution() {
        int solution = 0;
        for(long i = 2; i < TARGET; i++){
            long eligibleAmicable = Divisors.getPrimeFactorsList(i).stream().reduce(0L, Long::sum) - i;
            if (eligibleAmicable > i && eligibleAmicable < TARGET && Divisors.getPrimeFactorsList(eligibleAmicable).stream().reduce(0L, Long::sum) - eligibleAmicable == i) solution += i + eligibleAmicable;
        }
        return solution;
    }
}
