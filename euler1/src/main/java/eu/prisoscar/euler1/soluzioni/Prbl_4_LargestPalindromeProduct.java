package eu.prisoscar.euler1.soluzioni;

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
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
