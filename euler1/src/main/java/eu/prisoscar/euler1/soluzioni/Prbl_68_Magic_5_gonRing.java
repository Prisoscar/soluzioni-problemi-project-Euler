package eu.prisoscar.euler1.soluzioni;

import org.paukov.combinatorics3.Generator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Prbl_68_Magic_5_gonRing {

    public static BigInteger getSolution(){
        BigInteger solution = new BigInteger("0");
        Generator.permutation(1,2,3,4,5,6,7,8,9,10)
                .simple()
                .stream()
                .filter(Prbl_68_Magic_5_gonRing::filterLowOuterValues)
                .forEach(System.out::println);
        return solution;
    }

    private static boolean filterLowOuterValues(List<Integer> permutation){
        for (int i = 0; i < permutation.size() / 2; i++){
            if (permutation.get(i) < 5) return false;
        }
        return true;
    }
}
