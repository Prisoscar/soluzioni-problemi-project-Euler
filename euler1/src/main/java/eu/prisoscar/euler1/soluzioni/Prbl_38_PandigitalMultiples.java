package eu.prisoscar.euler1.soluzioni;

import java.util.stream.IntStream;

/*
Take the number 192 and multiply it by each of 1, 2, and 3:

    192 × 1 = 192
    192 × 2 = 384
    192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
public class Prbl_38_PandigitalMultiples {

    private static final int MAX_PANDIGITAL_CONCATENATION_POSSIBLE = 10_000;

    public static int getSolution(){
        //long time = System.currentTimeMillis();
        return IntStream.rangeClosed(1, MAX_PANDIGITAL_CONCATENATION_POSSIBLE).parallel().map(Prbl_38_PandigitalMultiples::retrievePandigitalMultipleElseMinusOne).reduce(Integer::max).getAsInt();
        /*System.out.println("parallel");
        System.out.println((System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        IntStream.rangeClosed(1, MAX_PANDIGITAL_CONCATENATION_POSSIBLE).map(Prbl_38_PandigitalMultiples::retrievePandigitalMultipleElseMinusOne).reduce(Integer::max).getAsInt();
        System.out.println("single thread");
        System.out.println((System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        int counter = 0;
        int solution = 0;
        int possibleSolution;
        while(counter < MAX_PANDIGITAL_CONCATENATION_POSSIBLE){
            counter++;
            possibleSolution = retrievePandigitalMultipleElseMinusOne(counter);
            solution = Math.max(solution, possibleSolution);
        }
        System.out.println("while loop");
        System.out.println((System.currentTimeMillis() - time));
        return solution;*/
    }

    private static int retrievePandigitalMultipleElseMinusOne(int eligiblePanditalSubmultiple){
        StringBuilder concatenations = new StringBuilder(String.valueOf(eligiblePanditalSubmultiple));
        int counter = 1;
        while (concatenations.length() < 9){
            counter++;
            concatenations.append(eligiblePanditalSubmultiple *= counter);
        }
        return isPandigital(concatenations.toString()) && counter > 1? Integer.parseInt(concatenations.toString()) : -1;
    }

    private static boolean isPandigital (String stringNumber){
        if(stringNumber.length() > 9) return false;
        for (int i = 1; i < 10; i++){
            if(!stringNumber.contains(String.valueOf(i))) return false;
        }
        return true;
    }
}
