package eu.prisoscar.euler1.soluzioni;

import java.util.AbstractMap;

/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */
public class Prbl_9_SpecialPythagoreanTriplet {

    private static final int PYTHAGOREAN_SUM = 1000;

    public static AbstractMap.SimpleEntry<String, Integer> getSolution(){
        AbstractMap.SimpleEntry<String, Integer> solution = new AbstractMap.SimpleEntry<>("000", 0);
        for (int i = 1; i < PYTHAGOREAN_SUM - 1; i++){
            for (int j = i + 1; j <= PYTHAGOREAN_SUM - 1; j++){
                double squaresSum = Math.pow(i, 2) + Math.pow(j, 2);
                if (Math.sqrt(squaresSum) % 1 == 0 &&  Math.sqrt(squaresSum) + i + j == PYTHAGOREAN_SUM){
                    solution = new AbstractMap.SimpleEntry<>(String.valueOf(i) + " " + String.valueOf(j) + " " + String.valueOf(((Double)Math.sqrt(squaresSum)).intValue()), ((Double) (Math.sqrt(squaresSum) * i * j)).intValue());
                    return solution;
                }
            }
        }
        return solution;
    }
}
