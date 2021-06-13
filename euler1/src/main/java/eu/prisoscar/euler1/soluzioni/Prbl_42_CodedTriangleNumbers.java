package eu.prisoscar.euler1.soluzioni;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
 */
public class Prbl_42_CodedTriangleNumbers {

    public static int getSolution() throws FileNotFoundException {
        int solution = 0;
        List<String> wordsList;
        String txtLine;
        int _AMinus_1 = 'A' - 1;
        File namesTxtFile = new File(System.getProperty("user.dir") + "/p042_words.txt");
        Scanner scanNamesTxt = new Scanner(namesTxtFile);
        int wordValue = 0;

        txtLine = scanNamesTxt.nextLine();
        txtLine = txtLine.replace("\"", "");
        wordsList = Arrays.stream(txtLine.split(",")).collect(Collectors.toList());

        for (String word: wordsList){
            for (char letter: word.toCharArray()){
                wordValue += letter - _AMinus_1;
            }
            if (isWordTriangle(wordValue)) solution++;
            wordValue = 0;
        }

        return solution;
    }

    /*
    knowing that wordValue = (1/2)n*(n+1) with n = position on sequence and 1/2 = 0.5
    can obtain this:
    0.5*n^2 + 0.5n - wordValue = 0
    applying quadratic equation formula

               -b +- sqrt(b^2 - 4ac)
    n(1-2) = ____________________________
                     2a (in this case = 1)

     and taking only positive result, will obtain this:
     n = -0.5 + sqrt (1/4 + 2*wordValue)
     if n is an integer wornValue is contained in sequence and so is a triangle word
     */
    private static boolean isWordTriangle(int wordValue){
        double triangleSequencePosition;
        triangleSequencePosition = -0.5 + Math.sqrt((double)1 / 4 + 2 * wordValue);
        return triangleSequencePosition % 1 == 0;
    }
}
