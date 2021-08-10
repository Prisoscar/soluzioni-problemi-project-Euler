package eu.prisoscar.euler1.algoritmi_trasversali;

import java.math.BigInteger;

public class NumberPatterns {

    public static boolean isPandigital (long candidateNumber, int startRange, int endRange){
        if (startRange < 0 || endRange > 9) throw new UnsupportedOperationException("range should be not less than 0 and not greater than 9");
        String stringNumber = String.valueOf(candidateNumber);
        if(stringNumber.length() < startRange && stringNumber.length() > endRange) return false;
        for (int i = startRange; i <= endRange; i++){
            if(!stringNumber.contains(String.valueOf(i))) return false;
        }
        return true;
    }

    public static boolean isPalindrome(Number number){
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length() / 2; i++){
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - 1 - i)) return false;
        }
        return true;
    }

    public static int reverseNumber(int number){
        return Integer.parseInt(reverseStringNumber(String.valueOf(number)));
    }

    public static long reverseNumber(long number){
        return Long.parseLong(reverseStringNumber(String.valueOf(number)));
    }

    public static BigInteger reverseNumber (BigInteger number){
        return new BigInteger(reverseStringNumber(number.toString()));
    }

    public static boolean arePermutations (Number number1, Number number2){
        String number1String = String.valueOf(number1);
        String number2String = String.valueOf(number2);
        for(char digit: number1String.toCharArray()){
            number2String = number2String.replaceFirst(String.valueOf(digit), "");
        }
        return number2String.equals("");
    }

    /*
    Private methods
     */
    private static String reverseStringNumber(String numberString){
        return new StringBuilder(numberString).reverse().toString();
    }
}
