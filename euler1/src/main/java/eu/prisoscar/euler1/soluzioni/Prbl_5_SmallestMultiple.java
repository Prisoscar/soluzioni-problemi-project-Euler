package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

import java.util.List;

public class Prbl_5_SmallestMultiple {

    private static final int TARGET_DIVISOR = 20;

    public static int getSolution (){
        int solution;
        List<Long> primesList = PrimeNumbers.findPrimes(20);
        int minDivisorUnit = primesList.stream().reduce(1L, (subtotal, prime) -> subtotal * prime).intValue();
        boolean isSmallestMultiple = true;
        for (int i = minDivisorUnit;;i +=minDivisorUnit){
            for (int j = 1; j <= TARGET_DIVISOR; j++){
                if (i % j != 0){
                    isSmallestMultiple = false;
                    break;
                }
            }
            if (isSmallestMultiple){
                solution = i;
                break;
            }else{
                isSmallestMultiple = true;
            }
        }
        return solution;
    }
}
