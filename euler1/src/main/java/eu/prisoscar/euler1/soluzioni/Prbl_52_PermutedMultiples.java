package eu.prisoscar.euler1.soluzioni;

/*
It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.

Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class Prbl_52_PermutedMultiples {

    private static final int TARGET = 6;

    public static int getSolution(){
        boolean goldenNumber = true;
        for (int i = 102;;i++){
            for (int j = 2; j <= TARGET; j++){
               if (!areDigitsTheSame(i, i * j)) {
                   goldenNumber = false;
                   break;
               }
               if(goldenNumber) return i;
               goldenNumber = true;
            }
        }
    }

    private static boolean areDigitsTheSame(int controlValue, int valueToCheck){
        String controlValueString = String.valueOf(controlValue);
        String valueToCheckString = String.valueOf(valueToCheck);
        if(controlValueString.length() != valueToCheckString.length()) return false;
        for (char checkedChar: controlValueString.toCharArray()){
            valueToCheckString = valueToCheckString.replaceFirst(String.valueOf(checkedChar),"");
        }
        return valueToCheckString.isEmpty();
    }
}
