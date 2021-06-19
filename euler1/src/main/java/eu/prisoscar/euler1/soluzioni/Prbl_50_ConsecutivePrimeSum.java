package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.List;

/*
The prime 41, can be written as the sum of six consecutive primes:
41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */

//optimized after had consulting the prbl 50 thread first algorithm took several hours to give the solution
public class Prbl_50_ConsecutivePrimeSum {

    private static final int TARGET = 1_000_000;
    private static final int MAX_POSSIBLE_CONSECUTIVE_SUM = maxPossibleSumAmountBeforeTarget();

    public static long getSolution(){
        long solution = 0L;
        List<Long> primeNumbers = PrimeNumbers.findPrimes(TARGET);
        long actualSum;
        long possibleMaxSum;
        int actualCounter;
        for (int i = MAX_POSSIBLE_CONSECUTIVE_SUM; i > 0; i--){
            possibleMaxSum = 0;
            for (int k = 0; k < MAX_POSSIBLE_CONSECUTIVE_SUM; k++){
                actualSum = 0;
                actualCounter = 0;
                for (int j = k; actualCounter < i; j++){
                    actualSum += primeNumbers.get(j);
                    actualCounter++;
                }
                if(primeNumbers.contains(actualSum) && actualSum > possibleMaxSum) {
                    possibleMaxSum =  actualSum;
                }
            }
            if (possibleMaxSum > 0){
                solution = possibleMaxSum;
                break;
            }
        }
        return solution;
    }

    private static int maxPossibleSumAmountBeforeTarget(){
        List<Long> primeNumbers = PrimeNumbers.findPrimes(TARGET);
        int counter = 0;
        int sum = 0;
        while (sum < TARGET){
            sum += primeNumbers.get(counter);
            counter++;
        }
        return counter;
    }
}
