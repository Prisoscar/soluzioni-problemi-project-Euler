package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;

/*
The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number, 134217728=8^9, is a ninth power.

How many n-digit positive integers exist which are also an nth power?
 */
public class Prbl_63_PowerfulDigitCounts {

    //10^n is always an n+1 digits number
    //at a certain point 9^n is less than n digits number
    public static int getSolution(){
        int solution = 0;
        for(int i = 1;; i++){
            for (int j = 1; new BigInteger(String.valueOf(j)).pow(i).toString().length() <= i; j++){
                if (new BigInteger(String.valueOf(j)).pow(i).toString().length() == i) solution++;
            }
            //10^n is always an n+1 digits number (1 + n zeroes)
            //at a certain point 9^n is less than n digits number
            if (new BigInteger(String.valueOf(9)).pow(i).toString().length() < i) break;
        }
        return solution;
    }
}
