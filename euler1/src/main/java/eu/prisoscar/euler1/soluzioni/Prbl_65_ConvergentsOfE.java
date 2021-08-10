package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prbl_65_ConvergentsOfE {

    private static final int TARGET = 100;

    /*
    it seems that e continued fraction has a pattern of this kind:
    2 1 2     1 1 4 1 1 6 1 1 8 1 1 10 1 1 12 1 1 14 1 1 16 1 1 18 1 1 20...
    after first 3 terms we have a pattern of two ones and last number before first one of last couple of ones + 2
     */
    public static int getSolution(){
        int solution = 0;
        List<Integer> aList = new ArrayList<>(Arrays.asList(2, 1, 2));
        int lastThird = 2;
        int counter = 3;
        for (int i = 1; counter < TARGET ;counter++, i++){
            if (i % 3 == 0){
                aList.add(lastThird + 2);
                lastThird += 2;
            }else{
                aList.add(1);
            }
        }
        BigInteger numerator = new BigInteger("1");
        BigInteger denominator = new BigInteger(String.valueOf(aList.get(aList.size() - 1)));
        for(int i = aList.size() - 2; i >= 0; i--){
            numerator = denominator.multiply(new BigInteger(String.valueOf(aList.get(i)))).add(numerator);
            if (i > 0){
                BigInteger supportVariable = numerator;
                numerator = denominator;
                denominator = supportVariable;
            }
        }
        for(char digit: numerator.toString().toCharArray()){
            solution += Integer.parseInt(String.valueOf(digit));
        }
        return solution;
    }
}
