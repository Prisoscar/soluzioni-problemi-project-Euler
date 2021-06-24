package eu.prisoscar.euler1.algoritmi_trasversali;

import java.util.ArrayList;
import java.util.List;

public class NumberSequences {

    public static List<Long> triangleNumbersSequence(int target){
        List<Long> triangleSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            triangleSequence.add((long)i * (i + 1) / 2);
        }
        return triangleSequence;
    }

    public static List<Long> squareNumbersSequence (int target){
        List<Long> squareSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            squareSequence.add((long)Math.pow(i,2));
        }
        return squareSequence;
    }

    public static List<Long> pentagonalNumbersSequence(int target){
        List<Long> pentagonalSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            pentagonalSequence.add((long)i * (3L * i - 1) / 2);
        }
        return pentagonalSequence;
    }

    public static List<Long> hexagonalNumbersSequence(int target){
        List<Long> hexagonalSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            hexagonalSequence.add((long)i * (2L * i - 1));
        }
        return hexagonalSequence;
    }

    public static List<Long> heptagonalNumbersSequence(int target){
        List<Long> heptagonalSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            heptagonalSequence.add((long)i * (5L * i - 3) / 2);
        }
        return heptagonalSequence;
    }

    public static List<Long> octagonalNumbersSequence(int target){
        List<Long> octagonalSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            octagonalSequence.add((long)i * (3L * i - 2));
        }
        return octagonalSequence;
    }
}
