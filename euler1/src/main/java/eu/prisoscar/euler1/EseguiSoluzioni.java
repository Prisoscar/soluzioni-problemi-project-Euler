package eu.prisoscar.euler1;

import eu.prisoscar.euler1.soluzioni.Prbl_1_Multiples_3_5;
import eu.prisoscar.euler1.soluzioni.Prbl_49_PrimePermutations;
import eu.prisoscar.euler1.soluzioni.Prbl_51_PrimeDigitsReplacements;
import eu.prisoscar.euler1.soluzioni.Probl_60_PrimePairSets;

import java.util.*;

public class EseguiSoluzioni {
    public static void main(String[] args) {
        //Problem 1 https://projecteuler.net/problem=1
        System.out.println("solution of problem 1 is: " + Prbl_1_Multiples_3_5.sommaMultipli());

        //Problem 49 https://projecteuler.net/problem=49
        System.out.println("solution of problem 49 is: " + Prbl_49_PrimePermutations.permutation());

        //Problem 51 https://projecteuler.net/problem=51
        List<Long> solution51 = Prbl_51_PrimeDigitsReplacements.primeDigitReplaced();
        System.out.println("solution of problem 51 is:\n" + solution51 + "\nthe smallest prime is:\n" + solution51.get(0));

        //Problem 60 https://projecteuler.net/problem=60
        Map.Entry<Long, List<Long>> solution = Probl_60_PrimePairSets.sumPrimeSet();
        System.out.println("solution of problem 60 is: " + solution.getKey() + "\nobtained from the following prime numbers: " + solution.getValue());
    }
    
}
