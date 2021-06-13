package eu.prisoscar.euler1.soluzioni;

import org.paukov.combinatorics3.Generator;

import java.util.List;

/*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order,
but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

    d2d3d4=406 is divisible by 2
    d3d4d5=063 is divisible by 3
    d4d5d6=635 is divisible by 5
    d5d6d7=357 is divisible by 7
    d6d7d8=572 is divisible by 11
    d7d8d9=728 is divisible by 13
    d8d9d10=289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Prbl_43_SubStringDivisibility {

    public static long getSolution(){
        return Generator.
                permutation(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .simple()
                .stream()
                .mapToLong(Prbl_41_PandigitalPrime::arrayToLong)
                .filter(Prbl_43_SubStringDivisibility::isPropertyRespected)
                .reduce(0L, Long::sum);
    }

    private static boolean isPropertyRespected(long pandigitalNumber){
        String pandigitalNumberString = String.valueOf(pandigitalNumber);
        if (pandigitalNumberString.length() < 10) return false;
        int [] divisors = {2, 3, 5, 7, 11, 13, 17};
        for (int i = 0, j = 1; i < divisors.length; i++, j++){
            if(Integer.parseInt(pandigitalNumberString.substring(j, j + 3)) % divisors[i] != 0) return false;
        }
        return true;
    }
}
