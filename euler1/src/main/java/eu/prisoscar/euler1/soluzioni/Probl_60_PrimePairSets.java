package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.NumeriPrimi;
import java.util.List;

/*
    Problem 60 https://projecteuler.net/problem=60
    The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating
    them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime.
    The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

    Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
*/
public class Probl_60_PrimePairSets {
    public static Integer sumPrimeSet (){
        List<Long> primiAnalizzati = NumeriPrimi.trovaPrimi(1000000);
        
        for (int i = 1; primiAnalizzati.get(i) < 10000; i++) {
            
        }
        return null;
    }
    
    public static boolean areConcatenationsPrime (long num1, long num2, List<Long> primiAnalizati){
        return primiAnalizati.contains(Long.parseLong(String.valueOf(num1).concat(String.valueOf(num2)))) && primiAnalizati.contains(Long.parseLong(String.valueOf(num2).concat(String.valueOf(num1))));
    }
}
