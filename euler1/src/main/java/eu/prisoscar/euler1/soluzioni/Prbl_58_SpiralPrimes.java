package eu.prisoscar.euler1.soluzioni;

import eu.prisoscar.euler1.algoritmi_trasversali.PrimeNumbers;

/*
Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

(37) 36  35 34 33 32 (31)
 38 (17) 16 15 14 (13) 30
39 18  (5)  4  (3) 12 29
40 19  6  1  2 11 28
41 20  (7)  8  9 10 27
42 21 22 23 24 25 26
(43) 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal,
but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued,
what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
 */
public class Prbl_58_SpiralPrimes {

    private static final float TARGET = 0.1F;

    //starting from problem requirement point
    public static int getSolution(){
        int solution = 7;
        int primeDiagonalsNumbers = 8;
        int totalDiagonalsNumbers = 13;
        long lastDiagonalNumber = 49;
        //add layers
        for(int sideLength = 9; (float) primeDiagonalsNumbers / totalDiagonalsNumbers > TARGET; sideLength += 2){
            for(int side = 1; side <= 4; side++){
                lastDiagonalNumber += sideLength - 1;
                totalDiagonalsNumbers++;
                if(PrimeNumbers.isPrime(lastDiagonalNumber)) primeDiagonalsNumbers++;
            }
            solution = sideLength;
        }
        return solution;
    }
}
