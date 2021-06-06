package eu.prisoscar.euler1.soluzioni;

import java.util.ArrayList;
import java.util.List;

/*
Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

    1634 = 1^4 + 6^4 + 3^4 + 4^4
    8208 = 8^4 + 2^4 + 0^4 + 8^4
    9474 = 9^4 + 4^4 + 7^4 + 4^4

As 1 = 1^4 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Prbl_30_DigitFifthPowers {

    private static final int POWER = 5;
    private static final int MAX_POSSIBLE_SUM = (int) Math.pow(9,5) * 6;        //9^7 is still a 6 digits number

    public static int getSolution(){
        int solution = 0;
        List<Integer> analyzedNumberDigits;
        String analyzedNumberString;
        for(int i = 100; i < MAX_POSSIBLE_SUM; i++){
            analyzedNumberDigits = new ArrayList<>();
            analyzedNumberString = String.valueOf(i);
            for(int j = 0; j < analyzedNumberString.length(); j++){
                analyzedNumberDigits.add(Integer.parseInt(analyzedNumberString.substring(j, j+1)));
            }
            //System.out.println(analyzedNumberDigits.stream().reduce(0, (subtotal, lastDigit) -> subtotal = (int)Math.pow(subtotal, POWER) + (int)Math.pow(lastDigit, POWER)));
            if(analyzedNumberDigits.stream().mapToInt(digit -> (int)Math.pow(digit, POWER)).reduce(0, Integer::sum) == i) solution += i;
        }
        return solution;
    }
}
