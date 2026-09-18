import java.io.*;
import java.util.*;

public class Solution {

    // Helper method to check if a substring is a palindrome
    public static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static int palindromeIndex(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Check if removing the left character makes it a palindrome
                if (isPalindrome(s, left + 1, right)) {
                    return left;
                }
                // Check if removing the right character makes it a palindrome
                if (isPalindrome(s, left, right - 1)) {
                    return right;
                }
                // If neither works, it cannot be made a palindrome by removing one character
                return -1;
            }
        }
        
        // Already a palindrome
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();
        
        for (int i = 0; i < q; i++) {
            String s = scanner.next();
            System.out.println(palindromeIndex(s));
        }
        scanner.close();
    }
}
