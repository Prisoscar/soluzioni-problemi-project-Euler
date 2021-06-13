package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PatternsNumber;
import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;
import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example,
2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
 */
public class Prbl_41_PandigitalPrime {

    public static long getSolution() {
        long solution = 0;
        List<Integer> digits = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        while (solution == 0 && digits.size() > 0) {
            solution = Generator.permutation(digits)
                    .simple()
                    .stream()
                    .mapToLong(Prbl_41_PandigitalPrime::arrayToLong)
                    .filter(PrimeNumbers::isPrime)
                    .reduce(solution, Long::max);
            digits.remove(digits.size() - 1);
        }
        return solution;
    }

    protected static long arrayToLong(List<Integer> arrayToCommute){
        StringBuilder stringLong = new StringBuilder("");
        for(int digit: arrayToCommute){
            stringLong.append(digit);
        }
        return Long.parseLong(stringLong.toString());
    }
}
