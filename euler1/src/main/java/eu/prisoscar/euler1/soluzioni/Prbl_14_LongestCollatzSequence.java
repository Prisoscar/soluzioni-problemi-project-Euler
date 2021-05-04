package eu.prisoscar.euler1.soluzioni;

/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Prbl_14_LongestCollatzSequence {

    private static final int MAX_COLLATZ_START_NUMBER = 1_000_000;

    public static int getSolution(){
        int solution = 1;
        int solutionCounter = 1;
        int counter;
        long handledCollatzSequenceNumber;
        for(int i = 2; i <= MAX_COLLATZ_START_NUMBER; i++){
            handledCollatzSequenceNumber = i;
            counter = 0;
            do{
                handledCollatzSequenceNumber = handledCollatzSequenceNumber % 2 == 0 ?  handledCollatzSequenceNumber / 2 : 3 * handledCollatzSequenceNumber + 1;
                counter++;
            } while (handledCollatzSequenceNumber != 1);
            if(counter > solutionCounter){
                solutionCounter = counter;
                solution = i;
            }
        }
        return solution;
    }
}
