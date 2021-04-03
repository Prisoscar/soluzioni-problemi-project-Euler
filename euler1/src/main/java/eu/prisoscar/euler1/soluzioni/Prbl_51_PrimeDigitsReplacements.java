package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.ArrayList;
import java.util.List;

/*
problem 51 https://projecteuler.net/problem=51
By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.

By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers,
yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.

Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
*/
public class Prbl_51_PrimeDigitsReplacements {
    public static List<Long> primeDigitReplaced(){
        List<Long> primesList = PrimeNumbers.findPrimes(10000000);
        List<Long> droppedPrimes = new ArrayList<>();

        for(int i = 0; i <= primesList.size(); i++ ){
            /*if (droppedPrimes.contains(primesList.get(i))){
                continue;
            }*/
            for (int j = 0; j <= String.valueOf(primesList.get(i)).length(); j++){

            }
        }
        return null;
    }
}
