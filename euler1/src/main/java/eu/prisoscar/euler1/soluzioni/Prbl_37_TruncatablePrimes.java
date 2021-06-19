package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.List;

/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,
and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Prbl_37_TruncatablePrimes {

    //private static byte counter = 0;

    public static long getSolution(){
        List<Long> primeNumbersList = PrimeNumbers.findPrimes(1_000_000);
        return primeNumbersList.stream().map(Prbl_37_TruncatablePrimes::areTruncationsPrime).reduce(Long::sum).get();
    }

    private static long areTruncationsPrime(Long primeNumber){
        String stringPrime = String.valueOf(primeNumber);
        if(primeNumber <= 10) return 0L;
        if (isLeftTruncatedValuePrime(stringPrime.substring(1)) && isRightTruncatedValuePrime(stringPrime.substring(0, stringPrime.length() - 1))) {
            //counter++;
            return primeNumber;
        }
        return 0L;
    }

    private static boolean isLeftTruncatedValuePrime(String stringPrime){
        if(stringPrime.length() == 1) return PrimeNumbers.isPrime(Long.parseLong(stringPrime));
        return PrimeNumbers.isPrime(Long.parseLong(stringPrime)) && isLeftTruncatedValuePrime(stringPrime.substring(1));
    }

    private static boolean isRightTruncatedValuePrime(String stringPrime){
        if(stringPrime.length() == 1) return PrimeNumbers.isPrime(Long.parseLong(stringPrime));
        return PrimeNumbers.isPrime(Long.parseLong(stringPrime)) && isRightTruncatedValuePrime(stringPrime.substring(0, stringPrime.length() - 1));
    }
}
