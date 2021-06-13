package eu.prisoscar.euler1.algoritmi_trasversali;

public class PatternsNumber {

    public static boolean isPandigital (long candidateNumber, int startRange, int endRange){
        if (startRange < 0 || endRange > 9) throw new UnsupportedOperationException("range should be not less than 0 and not greater than 9");
        String stringNumber = String.valueOf(candidateNumber);
        if(stringNumber.length() < startRange && stringNumber.length() > endRange) return false;
        for (int i = startRange; i <= endRange; i++){
            if(!stringNumber.contains(String.valueOf(i))) return false;
        }
        return true;
    }
}
