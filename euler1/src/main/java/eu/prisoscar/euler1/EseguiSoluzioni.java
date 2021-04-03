package eu.prisoscar.euler1;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;
import eu.prisoscar.euler1.soluzioni.Prbl_51_PrimeDigitsReplacements;

import java.util.List;

public class EseguiSoluzioni {
    public static void main(String[] args) {
//        //problema 1 https://projecteuler.net/problem=1
//        System.out.println("La soluzione del problema 1 è: " + Prbl_1_Multiples_3_5.sommaMultipli());
//
//        //System.out.println(NumeriPrimi.trovaPrimi(1000000000) + "\n\n" + NumeriPrimi.trovaPrimi(10000000).size());
//        //problema 49 https://projecteuler.net/problem=49
//        System.out.println("La soluzione del problema 49 è: " + Prbl_49_PrimePermutations.permutation());
//
//        //problema 60 https://projecteuler.net/problem=60
//        Map.Entry<Long, List<Long>> solution = Probl_60_PrimePairSets.sumPrimeSet();
//        System.out.println("La soluzione del problema 60 è: " + solution.getKey() + " ottenuta dai segurnti primi: " + solution.getValue());

        //Problem 51 https://projecteuler.net/problem=60
        List<Long> solution51 = Prbl_51_PrimeDigitsReplacements.primeDigitReplaced();
        System.out.println("solution of problem 51 is:\n" + solution51 + "\nthe smallest prime is:\n" + solution51.get(0));
        
    }
    
}
