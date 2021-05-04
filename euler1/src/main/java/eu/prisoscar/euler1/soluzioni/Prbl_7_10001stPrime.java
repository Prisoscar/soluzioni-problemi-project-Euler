package eu.prisoscar.euler1.soluzioni;

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */
public class Prbl_7_10001stPrime {

    private static final int PRIME_ELEMENT = 10_000;

    public static int getSolution(){
        int solution = 0;
        int counter = 1;
        int lastPrime = 3;
        boolean isPrime = true;

        for (int i = 5; counter < PRIME_ELEMENT; i += 2){
            for (int j = 3; j < i/j + 1 ;j += 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
                if (isPrime) {
                    lastPrime = i;
                    counter++;
                    continue;
                }
                isPrime = true;

        }
        solution = lastPrime;
        return solution;
    }
}
