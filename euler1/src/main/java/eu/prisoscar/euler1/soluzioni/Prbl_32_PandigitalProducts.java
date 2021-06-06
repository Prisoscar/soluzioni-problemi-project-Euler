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

    private static final Collection<Integer> PANDIGITS = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    public static long getSolution(){
        long solution = 0;
        List<List<Integer>> pandigitsSubsets = Generator
                .subset(PANDIGITS)
                .simple()
                .stream().collect(Collectors.toList());
        //pandigitsSubsets.remove(new ArrayList<>(PANDIGITS));        //don't need 9 digits permutations
        pandigitsSubsets.remove(new ArrayList<>(Collections.singletonList(1)));  //remove neutral element 1
        List<Integer> allPandigitsLessThan9Digits = pandigitsSubsets.stream().map(pandigitSubset -> Generator
                .permutation(pandigitSubset)
                .simple()
                .stream().mapToInt(permutedPandigitSubset -> permutedPandigitSubset.stream().reduce(0, (partialNumber, lastDigit) -> partialNumber = Integer.parseInt(String.valueOf(partialNumber) + lastDigit, 10))).boxed()
        ).reduce(Stream.of((Integer) 2), (partialStream, lastStream) -> partialStream = Stream.concat(partialStream, lastStream)).sorted().collect(Collectors.toList());

        pandigitsSubsets.clear();
       /* Set<Integer> all9DigitsPandigits = Generator
                .permutation(PANDIGITS)
                .simple()
                .stream().mapToInt(permutation -> permutation.stream().reduce(0, (partialNumber, lastDigit) -> partialNumber = Integer.parseInt(String.valueOf(partialNumber) + lastDigit, 10))).boxed().collect(Collectors.toSet());*/
        int counter = 1;
        int counter2 = 1;
        for (Integer analyzedPermutation: allPandigitsLessThan9Digits){
            if( allPandigitsLessThan9Digits.size() / counter > allPandigitsLessThan9Digits.size() /counter2 * 10 ){
                System.out.println(counter2 + "0%");
                counter2++;
            }
            for (Integer analyzedDivisor: allPandigitsLessThan9Digits){
                if(((analyzedPermutation / analyzedDivisor) + 1) < analyzedDivisor) {
                    break;
                }
                if((Double.valueOf(analyzedPermutation) / analyzedDivisor) % 1 != 0) continue;
                if((analyzedPermutation / analyzedDivisor) == analyzedDivisor) break;
                if(allPandigitsLessThan9Digits.contains(analyzedPermutation / analyzedDivisor)){
                    solution += analyzedPermutation;
                    break;
                }
            }
            System.out.println(counter++);
        }
        return solution;
    }
}
