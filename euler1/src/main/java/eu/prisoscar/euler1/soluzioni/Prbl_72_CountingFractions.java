package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Divisors;
import org.paukov.combinatorics3.Generator;

import java.util.List;
import java.util.OptionalLong;

public class Prbl_72_CountingFractions {

    private static final int TARGET = 1_000_000;

    /*
        assuming d as the denominator of the fraction, the idea is to consider reduced proper fraction of d (rpf(d)) as:
        d - 1 - all prime factors of d - 1 each
        + all even subsets of prime factors obtained multiplying all the subset elements
        - all odd subsets of prime factors obtained multiplying all the subset elements
     */
    public static long getSolution(){
        long fractionsCounter = 0;
        for(long d = 2; d <= TARGET; d++) {
            long dFractions = d - 1;
            List<Long> primes = Divisors.getPrimeFactorsList(d);
            for (long prime : primes) {
                long counter = (d / prime) - 1;
                dFractions -= counter;
            }
            long finalD = d;
            OptionalLong opt = Generator.subset(primes)
                    .simple()
                    .stream()
                    .filter(subsetList -> subsetList.size() >= 2 && subsetList.size() % 2 == 0)
                    .mapToLong(subsetList -> {
                        long compositePrime = subsetList.stream().reduce(1L, (subtotal, lastValue) -> subtotal *= lastValue);
                        return (finalD / compositePrime) - 1;
                    })
                    .reduce(Long::sum);
            if (opt.isPresent()){
                dFractions += opt.getAsLong();
            }
            opt = Generator.subset(primes)
                    .simple()
                    .stream()
                    .filter(subsetList -> subsetList.size() >= 3 && subsetList.size() % 2 != 0)
                    .mapToLong(subsetList -> {
                        long compositePrime = subsetList.stream().reduce(1L, (subtotal, lastValue) -> subtotal *= lastValue);
                        return (finalD / compositePrime) - 1;
                    })
                    .reduce(Long::sum);
            if (opt.isPresent()){
                dFractions -= opt.getAsLong();
            }
            fractionsCounter += dFractions;
        }
        return fractionsCounter;
    }
}
