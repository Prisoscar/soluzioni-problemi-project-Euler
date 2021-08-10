package eu.prisoscar.euler1.soluzioni;

public class Prbl_64_OddPeriodSquareRoots {

    private static final int TARGET = 10_000;
    private static final int INITIAL_NUMBER = 2;

    /*
    Interesting stuff:
    https://planetmath.org/TableOfContinuedFractionsOfsqrtnFor1N102
    https://www.youtube.com/watch?v=H-Sy7EPkkEY&t=283s
     */
    public static int getSolution(){
        int solution = 0;
        int a, xNum, xDenom, a0, x0Num, x0Denom, oddCounter;
        for (int i = INITIAL_NUMBER; i <= TARGET; i++){
            if(Math.sqrt(i) % 1 == 0) continue;
            a0 = ((Double) Math.sqrt(i)).intValue();
            x0Num = a0;
            x0Denom = i - (a0 * a0);
            a = a0;
            xDenom = x0Denom;
            xNum = x0Num;
            oddCounter = 0;
            do{
                a = ((Double) ((Math.sqrt(i) + xNum) / xDenom)).intValue();
                xNum = (a * xDenom) - xNum;
                xDenom = (i - ((xNum) * (xNum))) / xDenom;
                oddCounter++;
            }while (xNum != x0Num || xDenom != x0Denom);
            if (oddCounter % 2 != 0) solution++;
        }
        return solution;
    }
}
