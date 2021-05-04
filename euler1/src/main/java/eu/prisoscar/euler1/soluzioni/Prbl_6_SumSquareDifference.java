package eu.prisoscar.euler1.soluzioni;

/*
The sum of the squares of the first ten natural numbers is,

        1^2+2^2+...+10^2=385

The square of the sum of the first ten natural numbers is,

        (1+2+...+10)^2=55^2=3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is

3025-385=2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Prbl_6_SumSquareDifference {

    private static final int TARGET = 100;

    public static long getSolution() {
        long solution;
        long sumSquares = 0;
        long squareSum = 0;
        for (int i = 1; i <= TARGET; i++){
            sumSquares += (long) Math.pow(i, 2);
        }
        for (int i = 1; i <= TARGET; i++){
            squareSum += i;
        }
        squareSum = (long) Math.pow(squareSum, 2);
        return squareSum - sumSquares;
    }
}
