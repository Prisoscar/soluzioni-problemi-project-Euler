package eu.prisoscar.euler1.algoritmi_trasversali;

import java.util.*;

public class Divisors {

    public static List<Long> getDivisorsList(Long number){
        if (number == 1) return Collections.singletonList(number);
        if (number < 1) return new ArrayList<>();
        List<Long> divisorsList = new LinkedList<>(Arrays.asList(1L, number));
        for (long i = 2L; i < number / i; i++){
            if (number % i == 0) divisorsList.addAll(Arrays.asList(i, number/i));
        }
        if (Math.sqrt(number) % 1 == 0) divisorsList.add((long)Math.sqrt(number));
        divisorsList.sort(Long::compare);
        return divisorsList;
    }
}
