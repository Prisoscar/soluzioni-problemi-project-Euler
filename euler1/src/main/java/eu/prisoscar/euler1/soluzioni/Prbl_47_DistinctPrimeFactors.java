package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Divisors;
import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/*
The first two consecutive numbers to have two distinct prime factors are:

14 = 2 × 7
15 = 3 × 5

The first three consecutive numbers to have three distinct prime factors are:

644 = 2² × 7 × 23
645 = 3 × 5 × 43
646 = 2 × 17 × 19.

Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 */
public class Prbl_47_DistinctPrimeFactors {

    private static final long SUPPOSED_TARGET = 1_000_000;

    public static long getSolution(){
        long solution = 0L;
        List<Long> _4DistinctPrimeFactorsEachNumbers = LongStream.rangeClosed(644, SUPPOSED_TARGET)
                .map(longNumber -> {
                    if (Divisors.getDivisorsList(longNumber).stream().filter(PrimeNumbers::isPrime).count() >= 4)
                        return longNumber;
                    else return 0;
                }).boxed().sorted().distinct().collect(Collectors.toList());
        for (int i = 1; i < _4DistinctPrimeFactorsEachNumbers.size() - 3; i++){
            if(_4DistinctPrimeFactorsEachNumbers.get(i + 3) == _4DistinctPrimeFactorsEachNumbers.get(i) + 3){
                solution = _4DistinctPrimeFactorsEachNumbers.get(i);
                break;
            }
        }
        return solution;
    }
}
