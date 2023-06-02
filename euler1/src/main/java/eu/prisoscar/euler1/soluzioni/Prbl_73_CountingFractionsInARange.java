package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

public class Prbl_73_CountingFractionsInARange {

    private static final int TARGET = 12_000;
    private static final double UPPER_LIMIT = 1D / 2;
    private static final double LOWER_LIMIT = 1D / 3;

    public static long getSolution() {
        long fractionsCounter = 0;
        long lastNum = 1;
        for(long d = 2; d <= TARGET; d++) {
            double fractionValue;
            for(long n = lastNum; n < d; n++){
                fractionValue = (double) n / d;
                if(fractionValue >= UPPER_LIMIT) break;
                if(PrimeNumbers.areRelativelyPrime(n, d)){
                    if(fractionValue > LOWER_LIMIT){
                        fractionsCounter++;
                    }else{
                        lastNum++;
                    }
                }
            }
        }
        return fractionsCounter;
    }
}
