package eu.prisoscar.euler1.soluzioni;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Prbl_24_LexicographicPermutations {

    private static final int TARGET = 1_000_000;
    private static final int [] DIGITS_TO_PERMUTE = new int[]{0,1,2,3,4,5,6,7,8,9};

    public static int[] getSolution(){
        int[] solution;
        solution = streamLexicographicalPermutations()
                .limit(TARGET)
                .reduce(new int[1], (lastPermutation, currentPermutation) -> lastPermutation = currentPermutation);
        return solution;
    }
    private static Stream<int[]> streamLexicographicalPermutations(){
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(new PermutationIterator<>(DIGITS_TO_PERMUTE), 0), false);
    }
}

//Algorithm: https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
class PermutationIterator<T> implements Iterator<int[]>{

    private long counter;
    private int[] lastPermutation;
    private final int HIGHEST_VALUE;

    public PermutationIterator(int [] lastPermutation){
        this.lastPermutation = lastPermutation;
        HIGHEST_VALUE = Arrays.stream(lastPermutation).max().isPresent() ? Arrays.stream(lastPermutation).max().getAsInt() : -1;
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        return tailLength() != lastPermutation.length;
    }

    @Override
    public int[] next() {
        if(counter == 0){
            counter++;
            return  lastPermutation;
        }
        int tailLength = tailLength();
        int pivotPosition = lastPermutation.length - tailLength - 1;
        int pivotValue = lastPermutation[pivotPosition];
        int swapValue = HIGHEST_VALUE;
        int swapPosition = 0;
        for(int i = pivotPosition; i < lastPermutation.length; i++){
            if (lastPermutation[i] > pivotValue && lastPermutation[i] <= swapValue) {
                swapValue = lastPermutation[i];
                swapPosition = i;
            }
        }
        swapNumbers(pivotPosition, swapPosition);
        reverseTail(tailLength);
        counter++;
        return lastPermutation;
    }

    private void reverseTail (int tailLength){
        int [] reversedTail = new int[tailLength];
        for (int i = tailLength - 1; i >= 0; i--){
            reversedTail [i] = lastPermutation[lastPermutation.length - 1 - i];
        }
        System.arraycopy(reversedTail, 0, lastPermutation, lastPermutation.length - tailLength, tailLength);
    }

    private void swapNumbers (int firstElementPosition, int secondElementPosition){
        int value1 = lastPermutation[firstElementPosition];
        int value2 = lastPermutation[secondElementPosition];
        lastPermutation[firstElementPosition] = value2;
        lastPermutation[secondElementPosition] = value1;
    }

    private int tailLength (){
        int tailLength = 1;
        int lastNum = lastPermutation[lastPermutation.length -1];
        for (int i = lastPermutation.length -2; i >= 0; i--, tailLength++){
            if (lastPermutation[i] < lastNum) break;
            lastNum = lastPermutation[i];
        }
        return tailLength;
    }
}
