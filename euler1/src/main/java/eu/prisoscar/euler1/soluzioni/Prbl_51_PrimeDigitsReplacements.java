package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;
import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
problem 51 https://projecteuler.net/problem=51
By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers,
yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
*/
public class Prbl_51_PrimeDigitsReplacements {

    private static List<Long> solution = new ArrayList<>();

    public static List<Long> primeDigitReplaced(){
        List<Long> primesList = PrimeNumbers.findPrimes(10000000);
        String primeString;
        Collection<Integer> digitsIndexes = new ArrayList<>();
        int digitsValue;
        List<List<Integer>> subsets;

        for(int i = 0; i <= primesList.size(); i++ ){

            primeString = String.valueOf(primesList.get(i));

            //Replacements for single and repeated digits of analyzed prime number
            //if the value of digit to be replaced is greater than 2 there is no way to find 8 primes by replacing that digit
            for (int j = 0; j <= 2; j++){
                digitsIndexes.clear();

                for(int k = 0; k < primeString.length(); k++){
                    if (primeString.charAt(k) == String.valueOf(j).charAt(0)){
                        digitsIndexes.add(k);
                    }
                }
                if(digitsIndexes.isEmpty()){
                    continue;
                }
                digitsValue = Integer.parseInt(String.valueOf(primeString.charAt(digitsIndexes.iterator().next())));
                subsets = Generator
                    .subset(digitsIndexes)
                    .simple()
                    .stream()
                    .collect(Collectors.toList());

                for (List<Integer> subset: subsets) {
                    if (!subset.isEmpty()) {
                        replaceDigits(primeString, digitsValue, subset);
                    }
                    if (solution.size() == 8){
                        return solution;
                    }
                }
            }
        }
        return null;
    }

    //replace digits of prime passed like string and put the primes obtained in the static attribute solution
    private static void replaceDigits(String primeString, int digitsValue, List<Integer> digitsIndexes) {

        long primeAnalyzed;
        char[] charArrayPrime = primeString.toCharArray();

        if (digitsIndexes.size() <= 0){
            return;
        }
        solution.clear();
        solution.add(Long.parseLong(primeString));

        for (int i = ++digitsValue; i <= 9; i++) {

            for (Integer digitsIndex : digitsIndexes) {

                charArrayPrime[digitsIndex] = (char) (i + '0');
            }
            primeAnalyzed = Long.parseLong(String.valueOf(charArrayPrime));
            if(PrimeNumbers.isPrime(primeAnalyzed)){
                solution.add(primeAnalyzed);
            }
            //if at a certain point is no more possible to obtain 8 primes with the possible replacements left, method will be aborted
            if(solution.size() + (10 - i) < 8){
                return;
            }
        }

    }
}
