package eu.prisoscar.euler1.soluzioni;

/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly
believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits
in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Prbl_33_DigitCancellingFractions {

    private static final int NUMERATOR_AND_DENOMINATOR_MAX_VALUE = 99;

    public static int getSolution(){
        int solution = 0;
        for (int i = 11; i <= NUMERATOR_AND_DENOMINATOR_MAX_VALUE; i++){
            for (int j = i + 1; j < NUMERATOR_AND_DENOMINATOR_MAX_VALUE; j++){
                
            }
        }
        return solution;
    }
}
