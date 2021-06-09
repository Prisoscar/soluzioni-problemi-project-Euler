package eu.prisoscar.euler1.algoritmi_trasversali;

import java.util.ArrayList;
import java.util.List;

//all algorithms for finding and handling prime numbers are within this class
public class PrimeNumbers {

    //prime numbers will be all put in a List, beware of OutOfMemory errors
    public static List<Long> findPrimes(long max) {

        List<Long> primesList = new ArrayList<>();
        long maxDiv;
        boolean isPrimo = false;

        //Supposing that 1 is not prime
        //up to 3 numbers are inserted manually on List
        if (max <= 1) {     //input validation
            return null;
        } else if (max == 2) {
            primesList.add(max);
            return primesList;
        } else if (max == 3) {
            primesList.add(2L);
            primesList.add(max);
            return primesList;
        } else {
            primesList.add(2L);
            primesList.add(3L);
        }

        //algorithm for finding prime numbers above 3
        for (long i = 3; i <= max; i += 2) {
            maxDiv = (i / 2) + 1;
            for (int j = 1; primesList.get(j / 2) < maxDiv; j += 2) {
                if (i % primesList.get(j) == 0) {
                    isPrimo = false;
                    break;
                }
                maxDiv = (i / primesList.get(j)) + 1;
            }
            if (isPrimo) {
                primesList.add(i);
            } else {
                isPrimo = true;
            }
        }

        return primesList;
    }

    //prime numbers will be all put in a List, beware of OutOfMemory errors
    public static List<Long> findPrimes(long min, long max) {

        List<Long> primesList = new ArrayList<>();
        long maxDiv = max / 2 +1;
        boolean isPrimo = true;

        if (min > max || min < 0) {
            return null;
        }

        if (min == max) {
            if (isPrime(max)) {
                primesList.add(max);
                return primesList;
            } else {
                return null;
            }
        }

        //Supposing that 1 is not prime
        //up to 3 numbers are inserted manually on List
        if (max == 2) {
            primesList.add(max);
            return primesList;
        } else if (max == 3) {
            primesList.add(2L);
            primesList.add(max);
            return primesList;
        }else if (max >= 3 && min <= 2){
            primesList.add(2L);
            primesList.add(3L);
        }else if (min == 3){
            primesList.add(min);
        }

        if (min < 5) min = 5;  //cast min to 5
        if (min % 2 == 0) min++;  //to avoid an even min number

        for (long i = min; i <= max; i += 2) {
            for (int j = 3; j < maxDiv; j += 2) {
                if (i % j == 0) {
                    isPrimo = false;
                    break;
                }
                maxDiv = (max / j) + 1;
            }
            if (isPrimo) {
                primesList.add(i);
            } else {
                isPrimo = true;
            }
        }
        /*
        fullPrimesList = findPrimes(max);

        for (long primo : fullPrimesList) {
            if (primo > max) {
                break;
            }
            if (primo >= min) {
                primesList.add(primo);
            }
        }*/
        return primesList;
    }

    //returns true if chosen number is prime
    public static boolean isPrime(long num) {

        long maxDiv = num / 2 +1;
        boolean isPrime = true;

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
                isPrime = false;
                break;
            }
            maxDiv = (num / j) + 1;
        }
        return isPrime;
    }
}
