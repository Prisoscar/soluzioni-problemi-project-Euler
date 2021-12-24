package eu.prisoscar.euler1.algoritmi_trasversali;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

//all algorithms for finding and handling prime numbers are within this class
public class PrimeNumbers {

    /**
     * @return the BigInteger stream of all prime number starting from 2
     */
    public static Stream<BigInteger> primesStream(){
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new PrimesIterator(new BigInteger("1")), 0), false);
    }

    /**
     * @param startingValue - value from which stream starts
     * @return the BigInteger stream of all prime number starting from given number
     * @throws UnsupportedOperationException if startingValue is negative
     */
    public static Stream<BigInteger> primesStream(BigInteger startingValue){
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new PrimesIterator(startingValue), 0), false);
    }

    /**
     * returns the list of all prime number up to chosen value
     * @param max (long) the number up to which find prime values
     * @return  List(Long)
     */
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
            for (int j = 3; primesList.get(j / 2) < maxDiv; j += 2) {
                if (i % primesList.get(j / 2) == 0) {
                    isPrimo = false;
                    break;
                }
                maxDiv = (i / primesList.get(j / 2)) + 1;
            }
            if (isPrimo) {
                primesList.add(i);
            } else {
                isPrimo = true;
            }
        }
        return primesList;
    }

    /**
     * returns the list of all prime number in the chosen range
     * @param min (long) the lower bound of the range
     * @param max (long) the higher bound of the range
     * @return  List(Long)
     */
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
        return primesList;
    }

    /**
     * tells if the passed in number is a prime number
     * @param num the long to check if is a prime number
     * @return (boolean) if the number is prime
     */
    public static boolean isPrime(long num) {

        long maxDiv = num / 2 + 1;
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

    /**
     * tells if the passed in number is a prime number
     * @param num the BigInteger to check if is a prime number
     * @return (boolean) if the number is prime
     */
    public static boolean isPrime(BigInteger num) {

        BigInteger maxDiv = num.divide(new BigInteger("2")).add(new BigInteger("1"));
        boolean isPrime = true;

        //Supposing that 1 is not prime
        //up to 3 numbers are inserted manually on List
        if (num.compareTo(new BigInteger("1")) <= 0) {     //input validation
            return false;
        } else if (num.compareTo(new BigInteger("2")) == 0) {
            return true;
        } else if (num.compareTo(new BigInteger("3")) == 0) {
            return true;
        }

        //returns false if num is even
        if (num.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0){
            return false;
        }

        for (BigInteger j = new BigInteger("3"); j.compareTo(maxDiv) < 1; j = j.add(new BigInteger("2"))) {
            if (num.mod(j).compareTo(new BigInteger("0")) == 0) {
                isPrime = false;
                break;
            }
            maxDiv = num.divide(j).add(new BigInteger("1"));
        }
        return isPrime;
    }

    /**
     * returns all relatively primes of the passed number, if the input is invalid returns an empty List
     * @param num - long number to check all relatively primes between 1 and num (num has to be >= 2)
     * @return  The List(Long) of all relatively prime numbers
     */
    public static List<Long> relativelyPrimes (long num){
        List<Long> numPrimeFactors = Divisors.getPrimeFactorsList(num);
        numPrimeFactors.remove(0);
        List<Long> relativelyPrimes = new ArrayList<>();
        boolean areRelativelyPrimes = true;
        //if invalid input is provided returns an empty List
        if(num <= 1L) return relativelyPrimes;
        relativelyPrimes.add(1L);
        for (long i = 2L; i < num; i++){
            List<Long> iPrimeFactors = Divisors.getPrimeFactorsList(i);
            iPrimeFactors.remove(0);
            for (Long primeFactor: iPrimeFactors){
                if (numPrimeFactors.contains(primeFactor)) {
                    areRelativelyPrimes = false;
                    break;
                }
            }
            if (areRelativelyPrimes){
                relativelyPrimes.add(i);
            } else {
                areRelativelyPrimes = true;
            }
        }
        return relativelyPrimes;
    }
}

// --- external classes --- \\
/*
iterator of prime numbers
 */
class PrimesIterator implements Iterator<BigInteger> {

    private BigInteger lastPrime;

    public PrimesIterator(BigInteger startingValue){
        if(startingValue.compareTo(new BigInteger("-1")) <= 0){
            throw new UnsupportedOperationException("prime starting number cannot be negative");
        }
        if(startingValue.compareTo(new BigInteger("3")) == 0){
            this.lastPrime = new BigInteger("-1");
            return;
        }
        if(startingValue.compareTo(new BigInteger("2")) <= 0){
            this.lastPrime = startingValue;
            return;
        }
        if (startingValue.mod(new BigInteger("2")).compareTo(new BigInteger("0")) == 0){
            this.lastPrime = startingValue.subtract(new BigInteger("1"));
        } else {
            this.lastPrime = startingValue.subtract(new BigInteger("2"));
        }
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public BigInteger next() {
        boolean foundPrime = false;
        if (this.lastPrime.compareTo(new BigInteger("-1")) == 0){
            this.lastPrime = new BigInteger("3");
            return new BigInteger("3");
        }
        if (this.lastPrime.compareTo(new BigInteger("2")) <= 0){
            this.lastPrime = new BigInteger("-1");
            return new BigInteger("2");
        }
        while (!foundPrime) {
            this.lastPrime = this.lastPrime.add(new BigInteger("2"));
            if (PrimeNumbers.isPrime(this.lastPrime)) foundPrime = true;
        }
        return this.lastPrime;
    }
}
