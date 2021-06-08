package eu.prisoscar.euler1.soluzioni;

import java.util.stream.IntStream;

/*
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: As 1! = 1 and 2! = 2 are not sums they are not included.
  */
public class Prbl_34_DigitFactorial {

    private static final int MAX_POSIBLE_SUM = factorial(9) * 7;
    public static int getSolution(){
        return IntStream.rangeClosed(3, MAX_POSIBLE_SUM).parallel().map(Prbl_34_DigitFactorial::factorialSum).reduce(0, Integer::sum);
    }

    private static int factorial(int number){
        return IntStream.rangeClosed(1, number).reduce(1, (partialMultiplication, lastNumber) -> partialMultiplication *= lastNumber);
    }

    private static int factorialSum(int number){
        int sum = 0;
        String stringifyNumber = String.valueOf(number);
        for (char digit: stringifyNumber.toCharArray()){
            sum += factorial(Character.getNumericValue(digit));
        }
        return sum = sum == number ? sum: 0;
    }
}
