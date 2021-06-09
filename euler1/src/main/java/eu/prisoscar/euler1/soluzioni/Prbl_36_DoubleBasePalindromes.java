package eu.prisoscar.euler1.soluzioni;

import java.util.stream.IntStream;

/*
The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Prbl_36_DoubleBasePalindromes {

    private static final int TARGET = 1_000_000;

    public static int getSolution(){
         return IntStream.range(1, TARGET).parallel().map(analyzedNumber -> {
            if(isPalindrome(String.valueOf(analyzedNumber)) && isPalindrome(Integer.toBinaryString(analyzedNumber))) return analyzedNumber;
            else return 0;
        }).reduce(0, Integer::sum);
    }

    private static boolean isPalindrome(String numString){
        for (int i = 0; i < numString.length() / 2; i++){
            if(numString.charAt(i) != numString.charAt(numString.length() - 1 - i)) return false;
        }
    return true;
    }
}
