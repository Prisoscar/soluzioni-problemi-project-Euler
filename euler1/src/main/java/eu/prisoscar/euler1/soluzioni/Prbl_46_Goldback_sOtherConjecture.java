package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.ArrayList;
import java.util.List;

/*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.

9 = 7 + 2×1^2
15 = 7 + 2×2^2
21 = 3 + 2×3^2
25 = 7 + 2×3^2
27 = 19 + 2×2^2
33 = 31 + 2×1^2

It turns out that the conjecture was false.

What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class Prbl_46_Goldback_sOtherConjecture {

    private static final int SUPPOSED_TARGET = 100_000;

    public static long getSolution(){
        long solution = 0;
        boolean found = false;
        List<Long> compositeOddsNumbers = getCompositesOddsNumbers(SUPPOSED_TARGET);
        List<Long> primeNumbers = PrimeNumbers.findPrimes(SUPPOSED_TARGET);
        List<Long> twiceSquareNumbers = getTwiceSquareNumbers(SUPPOSED_TARGET);
        for (long compositeOddsNumber: compositeOddsNumbers){
            for (long primeNumber: primeNumbers){
                for (long twiceSquareNumber: twiceSquareNumbers){
                    if (primeNumber + twiceSquareNumber == compositeOddsNumber) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if(!found) {
                solution = compositeOddsNumber;
                break;
            }else{
                found = false;
            }
        }
        return solution;
    }

    private static List<Long> getCompositesOddsNumbers(int target){
        List<Long> compositeOddsNumbers = new ArrayList<>();
        for (int i = 2; i <= target; i++){
            if(i % 2 != 0 && !PrimeNumbers.isPrime(i)) compositeOddsNumbers.add((long)i);
        }
        return compositeOddsNumbers;
    }

    private static List<Long> getTwiceSquareNumbers (int target){
        List<Long> twiceSquareNumbers = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(target) / 2; i++){
            twiceSquareNumbers.add(2L * Double.valueOf(Math.pow(i, 2)).longValue());
        }
        return twiceSquareNumbers;
    }
}
