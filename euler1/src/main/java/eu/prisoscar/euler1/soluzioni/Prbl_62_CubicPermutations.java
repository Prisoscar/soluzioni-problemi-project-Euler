package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.NumberPatterns;

import java.util.ArrayList;
import java.util.List;

/*
The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3). In fact,
41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.

Find the smallest cube for which exactly five permutations of its digits are cube.
 */
public class Prbl_62_CubicPermutations {

    private static final int STARTING_NUMBER = 406;
    private static final int TARGET = 10_000;

    public static long getSolution(){
        List<Long> cubesList = new ArrayList<>();
        for (int i = STARTING_NUMBER; i <= TARGET; i++){
            cubesList.add((long) Math.pow(i, 3));
        }
        for(int i = 0; i < cubesList.size(); i++){
            List<Long> permutationsSet = new ArrayList<>();
            permutationsSet.add(cubesList.get(i));
            for(int j = i + 1; j < cubesList.size() && (String.valueOf(cubesList.get(j)).length() == String.valueOf(cubesList.get(i)).length()); j++){
                if (NumberPatterns.arePermutations(cubesList.get(i), cubesList.get(j))) permutationsSet.add(cubesList.get(j));
            }
            if (permutationsSet.size() == 5) return cubesList.get(i);
        }
        return 0L;
    }
}
