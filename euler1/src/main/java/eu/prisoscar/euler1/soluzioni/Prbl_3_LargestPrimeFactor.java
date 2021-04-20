package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.List;

public class Prbl_3_LargestPrimeFactor {

    private static final long TARGET = 600851475143L;

    public static long getSolution (){
        long solution = 0L;
        List<Long> primeNumbers = PrimeNumbers.findPrimes(1_000_000);      //it's enough: (TARGET / 1.000.000) = 600.851,475143

        for (int i = 1; primeNumbers.get(i) < TARGET/primeNumbers.get(i); i++){
            if (TARGET % primeNumbers.get(i) == 0){
                solution = primeNumbers.get(i);
            }
        }

        return solution;
    }
}
