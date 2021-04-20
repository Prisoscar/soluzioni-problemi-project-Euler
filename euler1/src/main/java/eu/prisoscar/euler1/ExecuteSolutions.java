package eu.prisoscar.euler1;

import eu.prisoscar.euler1.soluzioni.*;
import javax.script.ScriptException;
import java.util.*;

public class ExecuteSolutions {
    public static void main(String[] args) throws ScriptException {
        //Problem 1 https://projecteuler.net/problem=1
        System.out.println("solution of problem 1 is: " + Prbl_1_Multiples_3_5.getSolution());

        //Problem 2 https://projecteuler.net/problem=2
        System.out.println("solution of problem 2 is: " + Prbl_2_EvenFibonacciNumbers.getSolution());

        //Problem 3 https://projecteuler.net/problem=3
        System.out.println("solution of problem 3 is: " + Prbl_3_LargestPrimeFactor.getSolution());

        //Problem 4 https://projecteuler.net/problem=4
        int [] solution4 = Prbl_4_LargestPalindromeProduct.getSolution();
        System.out.println("solution of problem 4 is: " + solution4[0] + " obtained from: " + solution4[1] + " * " + solution4[2]);

        //Problem 49 https://projecteuler.net/problem=49
        System.out.println("solution of problem 49 is: " + Prbl_49_PrimePermutations.permutation());

        //Problem 51 https://projecteuler.net/problem=51
        List<Long> solution51 = Prbl_51_PrimeDigitsReplacements.primeDigitReplaced();
        System.out.println("solution of problem 51 is:\n" + solution51 + "the smallest prime is:\n" + solution51.get(0));

//        //Problem 60 https://projecteuler.net/problem=60
//        //slow
//        Map.Entry<Long, List<Long>> solution = Prbl_60_PrimePairSets.sumPrimeSet();
//        System.out.println("solution of problem 60 is: " + solution.getKey() + "obtained from the following prime numbers: " + solution.getValue());
//
//        //Problem 93 https://projecteuler.net/problem=93
//        //too damn slow
//        //solution of problem 93 is 1258, max natural number obtained is 51
//        AbstractMap.SimpleEntry<Integer, Integer> solution93 = Prbl_93_ArithmeticExpressions.findSet();
//        System.out.println("solution of problem 93 is " + solution93.getKey() + ", max natural number obtained is " + solution93.getValue());

    }
    
}