package eu.prisoscar.euler1.soluzioni;

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
