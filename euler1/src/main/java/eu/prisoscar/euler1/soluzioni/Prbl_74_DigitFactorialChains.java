package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Operations;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Prbl_74_DigitFactorialChains {

    private static final int TARGET = 1_000_000;

    public static long getSolution(){
        long counter = 0;
        List<String> factorialChain;
        for(int i = 1; i <= TARGET; i++){
            factorialChain = new LinkedList<>();
            String lastChainValue = String.valueOf(i);
            factorialChain.add(lastChainValue);
            do{
                lastChainValue = calculateNextTerm(lastChainValue);
                if (factorialChain.contains(lastChainValue)){
                    break;
                }
                factorialChain.add(lastChainValue);
            }while (factorialChain.size() < 61);
            if (factorialChain.size() == 60){
                counter++;
            }
        }
        return counter;
    }

    private static String calculateNextTerm(String num){
        char[] digits = num.toCharArray();
        BigInteger factorialSum = BigInteger.ZERO;
        for (char digit: digits){
            factorialSum = factorialSum.add(Operations.factorial(digit - 48));
        }
        return factorialSum.toString();
    }
}
