package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Divisors;

import java.util.HashSet;
import java.util.Set;

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However,
this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Prbl_23_NonAbundantSums {

    private static final int UPPER_LIMIT = 28123;

    public static int getSolution(){
        int solution = 0;
        Set<Long> sumsOfAbundantNumbers = new HashSet<>();
        Set<Long> abundantNumbersSet = new HashSet<>();
        for (long i = 2; i < UPPER_LIMIT; i++){
            if (Divisors.getPrimeFactorsList(i).stream().reduce(0L, Long::sum) - i > i) abundantNumbersSet.add(i);
        }
        for (Long analyzedAbundantNumber : abundantNumbersSet){
            for (Long otherAbundantNumber : abundantNumbersSet) {
                if (analyzedAbundantNumber + otherAbundantNumber < UPPER_LIMIT) sumsOfAbundantNumbers.add(analyzedAbundantNumber + otherAbundantNumber);
            }
        }
        for (int i = 1; i < UPPER_LIMIT; i++){
            if (!sumsOfAbundantNumbers.contains((long) i)) solution += i;
        }
        return solution;
    }
}
