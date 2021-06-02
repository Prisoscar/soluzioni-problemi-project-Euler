package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

/*
Euler discovered the remarkable quadratic formula:
        n^2+n+41
It turns out that the formula will produce 40 primes for the consecutive integer values 0<=n<=39. However, when n=40, 40^2+40+41=40(40+1)+41
is divisible by 41, and certainly when n=41,41^2+41+41 is clearly divisible by 41.

The incredible formula n^2-79n+1601 was discovered, which produces 80 primes for the consecutive values 0<=n<=79.
The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

n^2+an+b, where |a|<1000 and |b|<= 1000

where |n| is the modulus/absolute value of n e.g. |11| = 11 and |-4| = 4

Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
 */
public class Prbl_27_QuadraticPrimes {

    private static final int TARGET = 1000;

    public static int getSolution(){
        int solution = 41;
        int consecutivePrimes = 39;
        for(int a = - (TARGET -1); a < TARGET; a++){
            for (int b = -TARGET; b <= TARGET; b++){
                if (!PrimeNumbers.isPrime(b)) continue;
                int partialConsecutivePrimes = 0;
                for (int n = 0; PrimeNumbers.isPrime((long) (Math.pow(n,2) + (long) a * n + b)); n++){
                    partialConsecutivePrimes = n;
                }
                if (partialConsecutivePrimes > consecutivePrimes) {
                    consecutivePrimes = partialConsecutivePrimes;
                    solution = a * b;
                }
            }
        }
        return solution;
    }
}
