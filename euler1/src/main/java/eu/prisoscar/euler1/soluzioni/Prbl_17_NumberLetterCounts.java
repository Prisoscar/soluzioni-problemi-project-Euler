package eu.prisoscar.euler1.soluzioni;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen)
contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
public class Prbl_17_NumberLetterCounts {

    private static final int TARGET = 1000;

    public static int getSolution(){
        int solution = 0;

        for(int i = 1; i <= TARGET; i++){
            solution += lettersNumber(i);
        }
        return solution;
    }

    private static int lettersNumber (int number){
        if (number == 1000) return 11;      //one thousand
        if (number == 10) return 3;     //ten
        if (11 <= number && number <= 19) return _11To19Number(number);
        int subtotal = 0;
        String numberString = String.valueOf(number);
        switch (numberString.length()) {
            case 3:
                subtotal += _3DigitsNumbers(Integer.parseInt(String.valueOf(number).substring(0, 1)));
                if (String.valueOf(number).substring(1).equals("00")) return subtotal -3;       //x hundred and (and not required)
                break;
            case 2:
                subtotal += _2DigitsNumbers(Integer.parseInt(String.valueOf(number).substring(0, 1)));
                break;
            case 1:
                subtotal += _1DigitNumber(Integer.parseInt(String.valueOf(number)));
                break;
        }
        if (String.valueOf(number).length() > 1)  subtotal += lettersNumber(Integer.parseInt(String.valueOf(number).substring(1)));
        return subtotal;
    }

    private static int _3DigitsNumbers (int digit){
        int numberOfLetters = 10;       //hundred and
        return numberOfLetters + _1DigitNumber(digit);
    }

    private static int _2DigitsNumbers (int digit){
        int numberOfLetters = 0;
        switch (digit){
            case 4:     //forty
            case 5:     //fifty
            case 6:     //sixty
                numberOfLetters = 5;
                break;
            case 2:     //twenty
            case 3:     //thirty
            case 8:     //eighty
            case 9:     //ninety
                numberOfLetters = 6;
                break;
            case 7:     //seventy = 7
                numberOfLetters = 7;
                break;

        }
        return numberOfLetters;
    }

    private static int _1DigitNumber (int digit){
        int numberOfLetters = 0;
        switch (digit){
            case 1:     //one
            case 2:     //two
            case 6:     //six
                numberOfLetters = 3;
                break;
            case 4:     //four
            case 5:     //five
            case 9:     //nine
                numberOfLetters = 4;
                break;
            case 3:     //three
            case 7:     //seven
            case 8:     //eight
                numberOfLetters = 5;
                break;
        }
        return numberOfLetters;
    }

    private static int _11To19Number(int number){
        int numberOfLetters = 0;
        switch (number){
            case 11:        //eleven
            case 12:        //twelve
                numberOfLetters = 6;
                break;
            case 15:        //fifteen
            case 16:        //sixteen
                numberOfLetters = 7;
                break;
            case 13:        //thirteen
            case 14:        //fourteen
            case 18:        //eighteen
            case 19:        //nineteen
                numberOfLetters = 8;
                break;
            case 17:        //seventeen
                numberOfLetters = 9;
                break;
        }
        return numberOfLetters;
    }
}
