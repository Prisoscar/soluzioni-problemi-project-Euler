package eu.prisoscar.euler1.soluzioni;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

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

    public static int getSolution(){
        int solution = 7;
        System.out.println((double) 1/7);
        System.out.println(String.valueOf((double) 1/7).length());
        String _1_7nth = new BigDecimal("1").divide(new BigDecimal("77"), 1000, RoundingMode.HALF_EVEN).toString();
        System.out.println(_1_7nth);
        _1_7nth = _1_7nth.replace("0.", "");
        System.out.println(_1_7nth);
        String [] split_1_7nt = _1_7nth.split(_1_7nth.substring(0, 1));
        Arrays.stream(split_1_7nt).forEach(System.out::println);
        System.out.println(split_1_7nt.length);

        return solution;
    }
}
