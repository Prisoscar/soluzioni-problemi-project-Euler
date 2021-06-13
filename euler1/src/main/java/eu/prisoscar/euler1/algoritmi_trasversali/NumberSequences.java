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

    public static List<Long> pentagonNumbersSequence(int target){
        List<Long> pentagonSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            pentagonSequence.add((long)i * (3L * i - 1) / 2);
        }
        return pentagonSequence;
    }

    public static List<Long> hexagonNumbersSequence(int target){
        List<Long> hexagonSequence = new ArrayList<>();
        for (int i = 1; i <= target; i++){
            hexagonSequence.add((long)i * (2L * i - 1));
        }
        return hexagonSequence;
    }
}
