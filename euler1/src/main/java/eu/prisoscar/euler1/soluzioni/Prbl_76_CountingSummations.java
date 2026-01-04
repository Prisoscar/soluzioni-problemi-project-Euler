package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.Divisors;

import java.util.concurrent.atomic.AtomicLong;

public class Prbl_76_CountingSummations {

    private static final int TARGET = 5;

    public static long getSolution(){
       // AtomicLong counter = new AtomicLong(0L);
        //return permutate(0, TARGET, TARGET - 1, TARGET - 1, 0L);
        //return counter.get();
        System.out.println(Divisors.getFactorsList(4L));
        return -1;
        //return calculatePermutations(TARGET);
    }

    private static long permutate (int subtotal, int target,  int lastGreater, int lastLess, long permutationsCounter){
        if (lastLess == 0) return permutationsCounter;
        if (subtotal + lastLess > target) return permutate(subtotal, target, lastGreater, --lastLess, permutationsCounter);
        if (subtotal + lastLess == target) {
            //permutationsCounter.set(permutationsCounter.get() + 1);
            //return ++permutationsCounter;
            return permutate(0, target, --lastGreater, lastGreater, permutationsCounter + 1);
        }

        return permutate(subtotal + lastGreater, target,  lastGreater, lastLess, permutationsCounter);
        //return lastGreater;
    }

    private static long calculatePermutations (int toPermute){
        if (toPermute == 2) return 1;
        return 1 + calculatePermutations(toPermute - (toPermute - 1));
    }
}
