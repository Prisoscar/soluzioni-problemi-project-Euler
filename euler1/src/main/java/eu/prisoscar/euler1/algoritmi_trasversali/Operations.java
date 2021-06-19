package eu.prisoscar.euler1.algoritmi_trasversali;

import java.math.BigInteger;

public class Operations {

//    public static long factorial(int analyzedNumber){
//        if(analyzedNumber == 0) return 1;
//        return analyzedNumber * factorial(--analyzedNumber);
//    }

    public static BigInteger factorial(int analyzedNumber){
        if(analyzedNumber == 0) return new BigInteger("1");
        return new BigInteger(String.valueOf(analyzedNumber)).multiply(factorial(--analyzedNumber));
    }

    public static long digitsSum(BigInteger number){
        long sum = 0;
        String numberString = number.toString();
        for (char digit: numberString.toCharArray()){
            sum += Long.parseLong(String.valueOf(digit));
        }
        return sum;
    }
}
