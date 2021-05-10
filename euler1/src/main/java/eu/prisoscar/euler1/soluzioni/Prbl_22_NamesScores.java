package eu.prisoscar.euler1.soluzioni;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */
public class Prbl_22_NamesScores {

    public static long getSolution() throws FileNotFoundException {
        long solution = 0L;
        List<String> namesList;
        String txtLine;
        long beforeA = 'A' - 1;
        File namesTxtFile = new File(System.getProperty("user.dir") + "\\names.txt");
        Scanner scanNamesTxt = new Scanner(namesTxtFile);
        txtLine = scanNamesTxt.nextLine();
        txtLine = txtLine.substring(1).substring(0, txtLine.length() - 2);
        namesList = Arrays.stream(txtLine.split("\",\"")).collect(Collectors.toList());
        namesList.sort(String::compareTo);
        for (int i = 0; i < namesList.size(); i++){
            long lettersSum = 0;
            for(char nameLetter : namesList.get(i).toCharArray()){
                lettersSum += nameLetter - beforeA;
            }
            solution +=  lettersSum * (i + 1);
        }
        return solution;
    }
}
