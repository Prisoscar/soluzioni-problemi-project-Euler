package eu.prisoscar.euler1.soluzioni;

import java.util.ArrayList;
import java.util.List;

/*
    Problem 1 https://projecteuler.net/problem=1
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Prbl_1_Multiples_3_5 {

    public static int getSolution() {

        List<Integer> listaMultipli = new ArrayList<>();
        int risultato;
        
        for (int i = 1; i <= Math.ceil(1000 / 3); i++) {
            listaMultipli.add(i * 3);
        }
        for (int i = 1; i < 1000 / 5; i++) {
            int multiplo = i * 5;
            if (multiplo % 3 != 0) {
                listaMultipli.add(multiplo);
            }
        }
        risultato = listaMultipli.stream().reduce(0, Integer::sum);
        return risultato;
    }
}
