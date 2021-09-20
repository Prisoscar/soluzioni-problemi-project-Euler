package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.List;

public class Prbl_69_TotientMaximum {

    private static final int TARGET = 1_000_000;

    public static long getSolution(){
        long solution = 6;
        float solutionOverSolutionsPhi = 3F;
        for(long i = solution; i <= TARGET; i += solution){
            List<Long> iRelativelyPrimesList = PrimeNumbers.relativelyPrimes(i);
            int iPhi = iRelativelyPrimesList.size();
            float iOverIPhi = (float)i / iPhi;
            if (iOverIPhi > solutionOverSolutionsPhi){
                solutionOverSolutionsPhi = iOverIPhi;
                solution = i;
            }
        }
        return solution;
    }
}
