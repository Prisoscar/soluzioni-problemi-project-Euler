package eu.prisoscar.euler1.soluzioni;

import java.util.stream.*;

/*
Consider all integer combinations of a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

    2^2=4, 2^3=8, 2^4=16, 2^5=32
    3^2=9, 3^3=27, 3^4=81, 3^5=243
    4^2=16, 4^3=64, 4^4=256, 4^5=1024
    5^2=25, 5^3=125, 5^4=625, 5^5=3125

If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
 */
public class Prbl_29_DistinctPowers {

    private static final int BEGIN_RANGE = 2;
    private static final int END_RANGE = 100;

    public static int getSolution(){
         return IntStream.rangeClosed(BEGIN_RANGE, END_RANGE).mapToObj(intNumber ->
            IntStream.rangeClosed(BEGIN_RANGE, END_RANGE).parallel().mapToDouble(intPower -> Math.pow(intNumber, intPower))
                    .boxed()
        )
                 .reduce(Stream.of(4D), (subtotal, lastStream)-> subtotal = Stream.concat(subtotal, lastStream))
                 .collect(Collectors.toSet()).size();
    }
}
