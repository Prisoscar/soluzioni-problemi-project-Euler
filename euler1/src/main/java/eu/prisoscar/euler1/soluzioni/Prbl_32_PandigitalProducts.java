package eu.prisoscar.euler1.soluzioni;

import org.paukov.combinatorics3.Generator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Prbl_32_PandigitalProducts {

    private static final Collection<Integer> PANDIGITAL_1_TO_9 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public static long getSolution(){
        long solution = 0;
        List<List<Integer>> pandigitalSubsets = Generator
                .subset(PANDIGITAL_1_TO_9)
                .simple()
                .stream().collect(Collectors.toList());
        pandigitalSubsets.remove(new ArrayList<>(Collections.singletonList(1)));  //remove neutral element 1
        List<Integer> allPandigitalLessThan9Digits = pandigitalSubsets.stream().map(pandigitalSubset -> Generator
                .permutation(pandigitalSubset)
                .simple()
                .stream().mapToInt(permutedPandigitalSubset -> permutedPandigitalSubset.stream().reduce(0, (partialNumber, lastDigit) -> partialNumber = Integer.parseInt(String.valueOf(partialNumber) + lastDigit, 10))).boxed()
        ).reduce(Stream.empty(), (partialStream, lastStream) -> partialStream = Stream.concat(partialStream, lastStream)).sorted().collect(Collectors.toList());

        String analyzedIdentity;
        int lastSize = 0;
        Set<Long> partialSolution = new LinkedHashSet<>();
        for (int i = 0; i < allPandigitalLessThan9Digits.size(); i++){
            for (int j = i;;j++){
                analyzedIdentity = strigifyIdentity(allPandigitalLessThan9Digits.get(i), allPandigitalLessThan9Digits.get(j));
                if (analyzedIdentity.length() < 9) continue;
                if (analyzedIdentity.length() > 9) break;
                if (allPandigitalLessThan9Digits.contains(Integer.parseInt(analyzedIdentity))) {
                    partialSolution.add((long) allPandigitalLessThan9Digits.get(i) * allPandigitalLessThan9Digits.get(j));
                }
            }
            if(allPandigitalLessThan9Digits.get(i) > 10000) break;
        }
        solution = partialSolution.stream().reduce(0L, Long::sum);
        return solution;
    }

    private static String strigifyIdentity (int multiplicand, int multiplier){
        return String.valueOf(multiplicand) + String.valueOf(multiplier) + String.valueOf(multiplicand * multiplier);
    }
}
