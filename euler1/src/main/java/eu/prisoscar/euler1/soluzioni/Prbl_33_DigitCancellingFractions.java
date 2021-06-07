package eu.prisoscar.euler1.soluzioni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly
believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits
in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Prbl_33_DigitCancellingFractions {

    private static final int NUMERATOR_AND_DENOMINATOR_MAX_VALUE = 100;

    public static int getSolution(){

        int solution = 0;
        List<String> wiredSimplifications = new ArrayList<>();
        StringBuilder numerators = new StringBuilder();
        StringBuilder denominators = new StringBuilder();
        int finalNumerator = 1;
        int finalDenominator = 1;

        for (int i = 11; i < NUMERATOR_AND_DENOMINATOR_MAX_VALUE; i++){
            if (i % 10 == 0) continue;
            for (int j = 11; j < NUMERATOR_AND_DENOMINATOR_MAX_VALUE; j++){
                if (i == j) continue;
                if (j % 10 == 0) continue;      //10 multiples divisions are trivial results and have to be ignored
                double originalDivisionResult = (double) i / j;
                if (originalDivisionResult > 1) continue;       //considering only division with a result less than 1
                Object [] iChars = String.valueOf(i).chars().mapToObj(intChar -> (char) intChar).toArray();
                Object [] jChars = String.valueOf(j).chars().mapToObj(intChar -> (char) intChar).toArray();
                //considering all possible combinations
                if (jChars [1] == iChars [1] && Double.parseDouble(iChars[0].toString()) / Double.parseDouble(jChars[0].toString()) == originalDivisionResult) wiredSimplifications.add(iChars[0].toString() + " " + jChars[0]);
                if (jChars [1] == iChars [0] && Double.parseDouble(iChars[1].toString()) / Double.parseDouble(jChars[0].toString()) == originalDivisionResult) wiredSimplifications.add(iChars[1].toString() + " " + jChars[0]);
                if (jChars [0] == iChars [1] && Double.parseDouble(iChars[0].toString()) / Double.parseDouble(jChars[1].toString()) == originalDivisionResult) wiredSimplifications.add(iChars[0].toString() + " " + jChars[1]);
                if (jChars [0] == iChars [0] && Double.parseDouble(iChars[1].toString()) / Double.parseDouble(jChars[1].toString()) == originalDivisionResult) wiredSimplifications.add(iChars[1].toString() + " " + jChars[1]);
            }
        }
        for(String partialSolution : wiredSimplifications){
            numerators.append(partialSolution.substring(0, 2));
            denominators.append(partialSolution.substring(1, 3));
        }
        denominators = new StringBuilder(denominators.substring(1));
        finalNumerator =Arrays.stream(numerators.toString().split(" ")).mapToInt(Integer::parseInt).reduce(finalNumerator, (subtotal, lastNum) -> subtotal *= lastNum);
        finalDenominator =Arrays.stream(denominators.toString().split(" ")).mapToInt(Integer::parseInt).reduce(finalDenominator, (subtotal, lastNum) -> subtotal *= lastNum);
        for (int i = finalNumerator - 1; i > 1; i--){
            if (((double) finalNumerator / i) % 1 == 0 && ((double) finalNumerator / i) % 1 == 0) {
                finalNumerator /= i;
                finalDenominator /= i;
            }
        }
        solution = finalDenominator;
        return solution;
    }
}
