package eu.prisoscar.euler1;

import eu.prisoscar.euler1.algoritmi_trasversali.NumeriPrimi;
import eu.prisoscar.euler1.soluzioni.Prbl_1_Multiples_3_5;
import eu.prisoscar.euler1.soluzioni.Prbl_49_PrimePermutations;
import eu.prisoscar.euler1.soluzioni.Probl_60_PrimePairSets;
import java.util.List;
import java.util.Map;

public class EseguiSoluzioni {
    public static void main(String[] args) {
        //problema 1 https://projecteuler.net/problem=1
        System.out.println("La soluzione del problema 1 è: " + Prbl_1_Multiples_3_5.sommaMultipli());
        
        //System.out.println(NumeriPrimi.trovaPrimi(1000000000) + "\n\n" + NumeriPrimi.trovaPrimi(10000000).size());
        //problema 49 https://projecteuler.net/problem=49
        System.out.println("La soluzione del problema 49 è: " + Prbl_49_PrimePermutations.permutation());
        
        //problema 60 https://projecteuler.net/problem=60
        Map.Entry<Long, List<Long>> solution = Probl_60_PrimePairSets.sumPrimeSet();
        System.out.println("La soluzione del problema 60 è: " + solution.getKey() + " ottenuta dai segurnti primi: " + solution.getValue());
        
    }
    
}
