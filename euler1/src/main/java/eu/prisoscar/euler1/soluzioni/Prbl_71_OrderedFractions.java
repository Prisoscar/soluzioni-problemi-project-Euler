package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

public class Prbl_71_OrderedFractions {

    private static final int TARGET = 1_000_000;
    private static final double TARGET_FRACTION_VALUE = 3D / 7;

    public static int getSolution(){
        int targetNumerator = 2;
        double lastLeftFractionValue = 2D / 5;
        for (int i = 2; i <= TARGET; i++){
            double fractionValue;
            for (int j = targetNumerator; j < i; j++){
                //try all fraction combination, if the fraction result
                //is suitable for being the value at left of 3/7
                //will check if is effectively a reduced proper fraction
                fractionValue = (double)j / i;
                if (fractionValue >= TARGET_FRACTION_VALUE) break;
                if (fractionValue > lastLeftFractionValue) {
                    if (PrimeNumbers.areCoprimes(i, j)) {
                        targetNumerator = j;
                        lastLeftFractionValue = fractionValue;
                    }
                }
            }
        }
        return targetNumerator;
    }
}
