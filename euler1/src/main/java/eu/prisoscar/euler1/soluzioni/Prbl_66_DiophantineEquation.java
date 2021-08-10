package eu.prisoscar.euler1.soluzioni;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
interesting staff
https://brilliant.org/wiki/quadratic-diophantine-equations-pells-equation/
 */
public class Prbl_66_DiophantineEquation {

    private static final int TARGET = 1_000;

    public static int getSolution() {
        int solution = 7;
        BigInteger solutionNumerator = new BigInteger("9");
        BigInteger x;
        for(int i = 2; i < TARGET; i++){
            List<Integer> continuedFractionCoefficients = getInitialNumberPlusPeriodArray(i);
            if (continuedFractionCoefficients == null) continue;
            int continuedFractionCoefficientsLength = continuedFractionCoefficients.size();
            /*
            according to up quoted link the smallest solution of Pell's equation can be derived from the continued fraction of sqrt(D)
             */
            if (continuedFractionCoefficientsLength % 2 != 0){
                continuedFractionCoefficients.remove(continuedFractionCoefficientsLength - 1);
            } else {
                for (int j = 1; j < continuedFractionCoefficientsLength - 1; j++){
                    continuedFractionCoefficients.add(continuedFractionCoefficients.get(j));
                }
            }
            List<BigInteger> finalFraction = getNumeratorAndDenominatorDerivedFromContinuedFractionCoefficients(continuedFractionCoefficients);
            x = finalFraction.get(0);
            if (x.compareTo(solutionNumerator) > 0) {
                solutionNumerator = x;
                solution = i;
            }
        }

        return solution;

    }

    /*
    from problem 64 gives as result the list of coefficients containing first number and the period of continued fraction
     */
    public static List<Integer> getInitialNumberPlusPeriodArray(int d){
        List<Integer> initialNumberPlusPeriodArray = new ArrayList<>();
        int a, xNum, xDenom, a0, x0Num, x0Denom, oddCounter;
            if(Math.sqrt(d) % 1 == 0) return null;
            a0 = ((Double) Math.sqrt(d)).intValue();
            x0Num = a0;
            x0Denom = d - (a0 * a0);
            a = a0;
            initialNumberPlusPeriodArray.add(a);
            xDenom = x0Denom;
            xNum = x0Num;
            oddCounter = 0;
            do{
                a = ((Double) ((Math.sqrt(d) + xNum) / xDenom)).intValue();
                xNum = (a * xDenom) - xNum;
                xDenom = (d - ((xNum) * (xNum))) / xDenom;
                oddCounter++;
                initialNumberPlusPeriodArray.add(a);
            }while (xNum != x0Num || xDenom != x0Denom);
        return initialNumberPlusPeriodArray;
    }

    /*
    gives back the list containing the total numerator and total denominator of continued fraction
    in this case the numerator represents the x and denominator the y
     */
    public static List<BigInteger> getNumeratorAndDenominatorDerivedFromContinuedFractionCoefficients(List<Integer> continuedFractionCoefficients){
        List<BigInteger> fractionNumeratorAndDenominator = new ArrayList<>();
        int counter = continuedFractionCoefficients.size() - 1;
        BigInteger lastNum = new BigInteger("1");
        BigInteger lastDenom = new BigInteger(String.valueOf(continuedFractionCoefficients.get(counter)));
        counter--;
        if (counter == -1){
            fractionNumeratorAndDenominator.add(lastNum);
            fractionNumeratorAndDenominator.add(lastDenom);
            return fractionNumeratorAndDenominator;
        }
        if (counter == 0){
            lastNum = (lastDenom.multiply(new BigInteger(String.valueOf(continuedFractionCoefficients.get(counter))))).add(lastNum);
            fractionNumeratorAndDenominator.add(lastNum);
            fractionNumeratorAndDenominator.add(lastDenom);
            return fractionNumeratorAndDenominator;
        }
        do{
            BigInteger supportVariable = lastDenom;
            lastDenom = lastNum;
            lastNum = supportVariable;
            lastNum = (lastDenom.multiply(new BigInteger(String.valueOf(continuedFractionCoefficients.get(counter))))).add(lastNum);
            counter--;
        } while (counter >= 0);
        fractionNumeratorAndDenominator.add(lastNum);
        fractionNumeratorAndDenominator.add(lastDenom);
        return fractionNumeratorAndDenominator;
    }
}
