package eu.prisoscar.euler1.soluzioni;

import java.util.Arrays;

public class Prbl_4_LargestPalindromeProduct {
    public static int [] getSolution(){
        int [] solution = new int[3];
        for(int i = 999; i >= 100; i--){
            for(int j = i; j >= 100; j--){
                if(isPalindrome(i*j) && solution[0] < i*j){
                    solution [0] = i*j;
                    solution [1] = i;
                    solution [2] = j;
                }
            }
        }
        return solution;
    }

    private static boolean isPalindrome (int n){
        boolean isPalindrome = true;
        String nString = String.valueOf(n);
        for (int i = 0; i < nString.length(); i++) {
            if(nString.charAt(i) != nString.charAt(nString.length()-1-i)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
