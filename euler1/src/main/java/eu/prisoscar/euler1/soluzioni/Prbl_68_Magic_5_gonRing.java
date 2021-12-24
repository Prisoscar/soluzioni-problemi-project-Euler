package eu.prisoscar.euler1.soluzioni;

import org.paukov.combinatorics3.Generator;

import java.math.BigInteger;
import java.util.List;

public class Prbl_68_Magic_5_gonRing {

    public static BigInteger getSolution(){
        BigInteger solution = new BigInteger("0");
        //permutations: positions from 0 to 4 are the external values
        //positions from 5 to 9 are the inner polygon
        return Generator.permutation(1,2,3,4,5,6,7,8,9,10)
                .simple()
                .stream()
                .filter(Prbl_68_Magic_5_gonRing::areSumsEquals)
                .map(Prbl_68_Magic_5_gonRing::stringifyPermutation)
                .filter(aggregatedValue -> aggregatedValue.toString().length() == 16)
                .reduce(new BigInteger("0"), (lastSmaller, actualValue) -> {
                    if (actualValue.compareTo(lastSmaller) > 0){
                        lastSmaller = actualValue;
                    }
                    return lastSmaller;
                });
    }

    private static boolean areSumsEquals(List<Integer> permutation){
        int sumValue = permutation.get(0) + permutation.get(5) + permutation.get(6);
        for (int i = 1; i <= 4; i++){
            int biggest = i + 6 == 10 ? 5 : i + 6;
            int sum = permutation.get(i) + permutation.get(i + 5) + permutation.get(biggest);
            if (sum != sumValue) return false;
        }
        return true;
    }

    private static BigInteger stringifyPermutation(List<Integer> permutation){
        String stringifyedPermutation = "";
        int lastOuterLowerValue = 11;
        int lowerOuterValuePosition = -1;
        for (int i = 0; i <= 4; i++){
            if (permutation.get(i) < lastOuterLowerValue){
                lastOuterLowerValue = permutation.get(i);
                lowerOuterValuePosition = i;
            }
        }
        for (int i = 0, j = lowerOuterValuePosition; i <= 4; i++){
            int biggest = j + 6 == 10 ? 5 : j + 6;
            stringifyedPermutation += permutation.get(j);
            stringifyedPermutation += permutation.get(j + 5);
            stringifyedPermutation += permutation.get(biggest);
            if (++j > 4) j = 0;
        }
        return new BigInteger(stringifyedPermutation);
    }
}
