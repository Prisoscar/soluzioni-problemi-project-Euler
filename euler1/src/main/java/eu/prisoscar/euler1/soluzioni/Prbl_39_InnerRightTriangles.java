package eu.prisoscar.euler1.soluzioni;

import java.util.*;

/*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Prbl_39_InnerRightTriangles {

    private static final int TARGET = 1_000;

    public static int getSolution(){
        int solution = 0;
        int ocurrencies = 0;
        Set<int []> pythagoreanTriplets = findAllPythagoreanTriplets();
        Map<Integer, Integer> solutionsForEachNumber = new Hashtable<>();
        for (int i = 1; i <= TARGET; i++){
            solutionsForEachNumber.put(i, 0);
        }
        for(int[] pythagoreanTriplet: pythagoreanTriplets){
            solutionsForEachNumber.computeIfPresent(Arrays.stream(pythagoreanTriplet).reduce(0, Integer::sum), (key, value) -> ++value);
        }
        for(Map.Entry<Integer, Integer> solutionWithCounterEntry: solutionsForEachNumber.entrySet()){
            if (solutionWithCounterEntry.getValue() > ocurrencies){
                ocurrencies = solutionWithCounterEntry.getValue();
                solution = solutionWithCounterEntry.getKey();
            }
        }
        return solution;
    }

    private static Set<int[]> findAllPythagoreanTriplets() {
        Set<int []> pythagoreanTriplets = new HashSet<>();
        for(int i = 1; i < TARGET; i++){
            for(int j = i; j < TARGET; j++){
                Double hypotenuse = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
                if (hypotenuse % 1 == 0) pythagoreanTriplets.add(new int[] {i, j , hypotenuse.intValue()});
            }
        }
        return pythagoreanTriplets;
    }
}