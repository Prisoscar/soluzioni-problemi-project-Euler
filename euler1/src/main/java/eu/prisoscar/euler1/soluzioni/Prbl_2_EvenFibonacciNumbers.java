package eu.prisoscar.euler1.soluzioni;

public class Prbl_2_EvenFibonacciNumbers {
    public static long getSolution(){
        long solution = 2;
        int secondLastFibonacciNumber = 1;
        int lastFibonacciNumber = 2;
        int newNumber = Integer.MIN_VALUE;
        while(newNumber < 4_000_000){
            newNumber = secondLastFibonacciNumber + lastFibonacciNumber;
            secondLastFibonacciNumber = lastFibonacciNumber;
            lastFibonacciNumber = newNumber;
            if(newNumber % 2 == 0){
                solution += newNumber;
            }
        }
        return solution;
    }
}
