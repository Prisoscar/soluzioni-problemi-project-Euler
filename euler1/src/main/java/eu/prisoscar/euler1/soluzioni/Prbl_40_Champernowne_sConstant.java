package eu.prisoscar.euler1.soluzioni;

/*
An irrational decimal fraction is created by concatenating the positive integers:

0.12345678910(1)112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Prbl_40_Champernowne_sConstant {

    private static final int TARGET = 1_000_000;
    private static final int JUMP = 10;

    public static int getSolution(){
        int solution = 1;
        StringBuilder champernowne_sConstant = new StringBuilder("");
        for(int i = 1; champernowne_sConstant.length() < TARGET; i++){
            champernowne_sConstant.append(i);
        }
        for(int i = 1; i <= TARGET; i *= JUMP){
            solution *= Integer.parseInt(champernowne_sConstant.toString().substring(i - 1, i));
        }
        return solution;
    }
}
