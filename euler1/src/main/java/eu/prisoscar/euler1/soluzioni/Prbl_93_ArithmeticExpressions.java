package eu.prisoscar.euler1.soluzioni;

import java.util.*;
import java.util.stream.Collectors;

/*
    By using each of the digits from the set, {1, 2, 3, 4}, exactly once, and making use of the four arithmetic
    operations (+, −, *, /) and brackets/parentheses, it is possible to form different positive integer targets.

    For example,

    8 = (4 * (1 + 3)) / 2
    14 = 4 * (3 + 1 / 2)
    19 = 4 * (2 + 3) − 1
    36 = 3 * 4 * (2 + 1)

    Note that concatenations of the digits, like 12 + 34, are not allowed.

    Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target numbers of which 36 is the maximum,
    and each of the numbers 1 to 28 can be obtained before encountering the first non-expressible number.

    Find the set of four distinct digits, a < b < c < d, for which the longest set of consecutive positive integers, 1 to n,
    can be obtained, giving your answer as a string: abcd.
    */
public class Prbl_93_ArithmeticExpressions {

    private static final byte DIGITS_SET_SIZE = 4;

    public static int findSet (){
        List<Set<Integer>> listOfDigitsSets = new ArrayList<>();
        List<List<Integer>> listOfArithmeticOperatorsSets = new ArrayList<>();
        List<? extends Collection<? extends Number>> temporaryList;

        //initialize listOfDigitsSets
        for (int i = 0; i < 10; i++){
            listOfDigitsSets.add(new HashSet<>(Collections.singletonList(i)));
        }
        //listOfDigitsSets.forEach(System.out::println);
/*
idea 1 - find all possible sets o 4 distinct digits
    then find all possible combinations of arithmetic expressions with repetitions between digits
    then find all possible brackets combinations
    then combine all together in all possible ways and evaluate the obtained expressions
 */
        //find all 0-9 4 distinct digit set
        for (int i = 0; i < DIGITS_SET_SIZE; i++){
            temporaryList = new ArrayList<>(listOfDigitsSets);
            listOfDigitsSets = new ArrayList<>();
            for (Collection<?> analyzedSet : temporaryList) {
                for (int j = analyzedSet.stream().mapToInt(v -> (int) v).max().orElseThrow(NoSuchElementException::new); j <= 9; j++) {
                    Set<Integer> digitsSet = new HashSet<>();
                    analyzedSet.forEach(number -> digitsSet.add((int)number));
                    digitsSet.add(j);
                    if(digitsSet.size() == (i + 1)) {
                        listOfDigitsSets.add(digitsSet);
                    }
                }
            }
            //listOfDigitsSets.forEach(System.out::println);
            //System.out.println(listOfDigitsSets.size());
        }
        //listOfDigitsSets.forEach(System.out::println);
        System.out.println(listOfDigitsSets.size() + " digits sets");

        // initialize listOfArithmeticOperatorsSets
        for (int i = 0; i <= 3; i++){
            listOfArithmeticOperatorsSets.add(new ArrayList<>(Collections.singletonList(i)));
            //listOfDigitsSets.add(new HashSet<>(Collections.singletonList(i)));
        }
        /*
        0 = +
        1 = -
        2 = *
        3 = /
         */

        //find all possible arithmetic operations combinations with repetitions
        for (int i = 0; i < 2; i++){
            temporaryList =new ArrayList<>(listOfArithmeticOperatorsSets);
            listOfArithmeticOperatorsSets = new ArrayList<>();
            for (Collection<?> analyzedSet : temporaryList)
                    for(int j = 0; j < 4; j++){
                        List<Integer> operatorsSet = new ArrayList<>();
                        analyzedSet.forEach(number -> operatorsSet.add((int) number));
                        operatorsSet.add(j);
                        listOfArithmeticOperatorsSets.add(operatorsSet);
                    }
            listOfArithmeticOperatorsSets.forEach(System.out::println);
            //System.out.println(listOfArithmeticOperatorsSets.size());
        }
        System.out.println(listOfArithmeticOperatorsSets.size() + " operators sets");


        //find all brackets combinations avoiding things like )( or ((n))



        //every integer result will be put in a set and a loop 1 to 9*8*7*6 will check the maximum consecutive integer that is element of the set
        return -1;
    }

}
