package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
    Problem 60 https://projecteuler.net/problem=60
    The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating
    them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime.
    The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

    Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 */
public class Prbl_60_PrimePairSets {

    private static final int SET_SIZE = 5;

    public static Entry<Long, List<Long>> getSolution() {
        List<Long> analyzedPrimes = PrimeNumbers.findPrimes(8_389);
        Map<Long, List<Long>> primeSets = new HashMap<>();
        Entry<Long, List<Long>> solution = null;

        List<List<Long>> setsList = new ArrayList<>();
        List<List<Long>> temporarySetsList;
        List<Long> primeSet = new ArrayList<>();
        boolean areConcatenationsPrimes = true;
        long setSum;

        assert analyzedPrimes != null;
        analyzedPrimes.remove(2L);
        /*
        In this algorithm I'll match every number with every else number in order to obtain all the couples that concatenations give prime numbers
        then I'll match every obtained couples with every number greater than the greater prime of the set in order to obtain all the sets of three primes where all concatenations will give prime numbers
        then I'll match every set of three with all numbers greater than the greater prime of the set  in order to obtain all sets of 4 elements that respect the concatenation rule
        then I'll match every set of 4 with every number greater than the greater prime of the set in order to obtain all sets of 5 numbers that respect the concatenation rule
        and at last I'll take the set with the lower sum
         */
        for (int i = 0; i < analyzedPrimes.size(); i++){
            for (int j = i; j < analyzedPrimes.size(); j++){
                if (areConcatenationsPrime(analyzedPrimes.get(i), analyzedPrimes.get(j))){
                    primeSet.add(analyzedPrimes.get(i));
                    primeSet.add(analyzedPrimes.get(j));
                    setsList.add(primeSet);
                    primeSet = new ArrayList<>();
                }
            }
        }
        //need to find set of 5
        for(int i = 2; i < SET_SIZE; i++){
            //last list of sets of i-dimension will be put in a temporary list and the new list of sets obtained will be 1-dimension greater
            temporarySetsList = new ArrayList<>(setsList);
            //clear the i-dimension list of sets in oder to be replaced with new  i+1-dimension list of sets
            setsList = new ArrayList<>();
            //step 1 - will analyze all i dimension sets
            for(List<Long> analyzedSet : temporarySetsList) {
                int greaterSetNumberIndex = analyzedPrimes.indexOf(analyzedSet.get(analyzedSet.size()-1));
                //step 2 - and will match to them all prime numbers greater than the greater number on analyzed set
                for (int j = ++greaterSetNumberIndex; j < analyzedPrimes.size(); j++) {
                    //step 3.1 - if concatenations between prime number and all prime of the analyzed set are prime numbers
                    for (long primeOfAnalyzedSet : analyzedSet){
                        if (!areConcatenationsPrime(primeOfAnalyzedSet, analyzedPrimes.get(j))){
                            areConcatenationsPrimes = false;
                            break;
                        }
                    }
                    //step 3.2 - I'll put the set with the new prime into the list of sets with i + 1 dimension
                    if (areConcatenationsPrimes){
                        primeSet = new ArrayList<>(analyzedSet);
                        primeSet.add(analyzedPrimes.get(j));
                        setsList.add(primeSet);
                    } else{
                        areConcatenationsPrimes = true;
                    }

                }
            }
        }
        for (List<Long> setOf5 : setsList){
            setSum = setOf5.stream().reduce(0L, Long::sum);     //sum all elements of analyzed set
            primeSets.put(setSum, setOf5);      //teh sum value is the key of map & the set's numbers are the value
        }
        setSum = Long.MAX_VALUE;
        for (Map.Entry<Long, List<Long>> entry : primeSets.entrySet()) {
            if (entry.getKey() < setSum){
                setSum = entry.getKey();
                solution = entry;
            }
        }
        return solution;
    }

    //checks if concatenations of 2 numbers are prime numbers
    private static boolean areConcatenationsPrime(long num1, long num2) {
        return PrimeNumbers.isPrime(Long.parseLong(String.valueOf(num1).concat(String.valueOf(num2)))) && PrimeNumbers.isPrime(Long.parseLong(String.valueOf(num2).concat(String.valueOf(num1))));
    }
}
