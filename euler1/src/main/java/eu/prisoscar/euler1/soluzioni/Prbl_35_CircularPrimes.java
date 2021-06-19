package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?
 */
public class Prbl_35_CircularPrimes {

    private static final int TARGET = 1_000_000;

    public static int getSolution(){
        int solution = 0;
        List<Long> primesNumber = PrimeNumbers.findPrimes(TARGET);
        for (Long primeNumber: primesNumber){
            if(isPrimeCircular(primeNumber)) {
                solution++;
            }
        }
        return solution;
    }

    private static boolean isPrimeCircular(Long prime){
        List<Long> rotationsList = getRotationsList(String.valueOf(prime));
        for (long rotation: rotationsList){
            if(!PrimeNumbers.isPrime(rotation)) return false;
        }
        return true;
    }

    private static List<Long> getRotationsList(String stringPrime){
        if (stringPrime.contains("0") || (stringPrime.contains("2") && !stringPrime.equals("2")) || stringPrime.contains("4") || stringPrime.contains("6") || stringPrime.contains("8")) return new ArrayList<>(Collections.singletonList(-1L));
        List<Long> rotationsList = new ArrayList<>();
        rotationsList.add(Long.parseLong(stringPrime));
        StringBuilder nextRotation;
        String lastRotation;
        for (int i = 1; i < stringPrime.length(); i++){
            lastRotation = String.valueOf(rotationsList.get(rotationsList.size() - 1));
            nextRotation = new StringBuilder(lastRotation.substring(lastRotation.length() - 1, lastRotation.length()));
            for (int j = 1; j < lastRotation.length(); j++){
                    nextRotation.append(lastRotation.charAt(j - 1));
            }
            rotationsList.add(Long.parseLong(nextRotation.toString()));
        }
        return rotationsList;
    }
}
