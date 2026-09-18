import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) {
            return result;
        }
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // Count frequencies for string p and the first window in s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        
        // Check the first window
        if (matches(pCount, sCount)) {
            result.add(0);
        }
        
        int windowSize = p.length();
        
        // Slide the window across the rest of string s
        for (int i = windowSize; i < s.length(); i++) {
            // Add the new character entering the window on the right
            sCount[s.charAt(i) - 'a']++;
            // Remove the character leaving the window on the left
            sCount[s.charAt(i - windowSize) - 'a']--;
            
            // If the frequency arrays match, record the start index
            if (matches(pCount, sCount)) {
                result.add(i - windowSize + 1);
            }
        }
        
        return result;
    }
    
    // Helper method to compare two frequency arrays
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
