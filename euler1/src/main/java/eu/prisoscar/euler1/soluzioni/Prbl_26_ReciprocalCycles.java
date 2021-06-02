package eu.prisoscar.euler1.soluzioni;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

    1/2	= 	0.5
    1/3	= 	0.(3)
    1/4	= 	0.25
    1/5	= 	0.2
    1/6	= 	0.1(6)
    1/7	= 	0.(142857)
    1/8	= 	0.125
    1/9	= 	0.(1)
    1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class Prbl_26_ReciprocalCycles {

    private static final int TARGET = 1000;
    private static final int FRACTIONAL_PART_DIGITS = 10_000;

    public static int getSolution(){
        int solution = 7;
        int longestRecurringPeriod = 6;
        for(int i = 11; i < TARGET; i++){
            String divisionResult = new BigDecimal("1").divide(new BigDecimal(String.valueOf(i)), FRACTIONAL_PART_DIGITS, RoundingMode.HALF_EVEN).toString();
            String [] recurringCycleArray = new String [] {"", "", ""};
            String recursion = "";
            for(int j = 2; j < FRACTIONAL_PART_DIGITS / 2 ;j++) {
                recursion = divisionResult.substring(divisionResult.length() - j, divisionResult.length() - 1);
                recurringCycleArray = divisionResult.split(recursion);
                if (recurringCycleArray.length <= 2) break;
                if(recurringCycleArray [1].equals("") && recurringCycleArray [recurringCycleArray.length - 2].equals("")) break;
            }
            if (recursion.length() >= longestRecurringPeriod) {
                solution = i;
                longestRecurringPeriod = recursion.length();
            }
        }
        //System.out.println("longest period is of: " + longestRecurringPeriod + " digits");
        return solution;
    }
}
