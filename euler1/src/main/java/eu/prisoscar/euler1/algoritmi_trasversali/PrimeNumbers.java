package eu.prisoscar.euler1.algoritmi_trasversali;

import java.util.ArrayList;
import java.util.List;

//all algorithms for finding and handling prime numbers are within this class
public class PrimeNumbers {

    //prime numbers will be all put in a List, beware of RAM saturation
    public static List<Long> findPrimes(long max) {

        List<Long> PrimesList = new ArrayList<>();
        long maxDiv;
        boolean isPrimo = false;

        //Supposing that 1 is not prime
        //up to 3 numbers are inserted manually on List
        if (max <= 1) {     //input validation
            return null;
        } else if (max == 2) {
            PrimesList.add(max);
            return PrimesList;
        } else if (max == 3) {
            PrimesList.add(2L);
            PrimesList.add(max);
            return PrimesList;
        } else {
            PrimesList.add(2L);
            PrimesList.add(3L);
        }

        //algorithm for finding prime numbers above 3
        for (long i = 3; i <= max; i += 2) {
            maxDiv = (i / 2) + 1;
            for (int j = 1; PrimesList.get(j) < maxDiv; j++) {
                if (i % PrimesList.get(j) == 0) {
                    isPrimo = false;
                    break;
                }
                maxDiv = (i / PrimesList.get(j)) + 1;
            }
            if (isPrimo) {
                PrimesList.add(i);
            } else {
                isPrimo = true;
            }
        }

        return PrimesList;
    }

    //prime numbers will be all put in a List, beware of RAM saturation
    public static List<Long> findPrimes(long min, long max) {

        List<Long> fullPrimesList;
        List<Long> primesList = new ArrayList<>();

        if (min > max || min < 0) {
            return null;
        }

        fullPrimesList = findPrimes(max);

        if (min == max) {
            if (isPrime(max)) {
                primesList.add(max);
                return primesList;
            } else {
                return null;
            }
        }
        for (long primo : fullPrimesList) {
            if (primo > max) {
                break;
            }
            if (primo >= min) {
                primesList.add(primo);
            }
        }
        return primesList;
    }

    //returns true if chosen number is prime
    public static boolean isPrime(long num) {

        long maxDiv = num/2 +1;
        boolean isPrimo = true;

        //Supposing that 1 is not prime
        //up to 3 numbers are inserted manually on List
        if (num <= 1) {     //input validation
            return false;
        } else if (num == 2) {
            return true;
        } else if (num == 3) {
            return true;
        }

        //returns false if num is even
        if (num % 2 == 0){
            return false;
        }

        for (long j = 3; j < maxDiv; j+=2) {
            if (num % j == 0) {
                isPrimo = false;
                break;
            }
            maxDiv = (num / j) + 1;
        }
        return isPrimo;
    }
}
