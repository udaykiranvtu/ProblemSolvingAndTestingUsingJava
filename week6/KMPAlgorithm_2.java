public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // Trick: check if s is a substring of (s+s) with one occurrence removed
        String doubled = s + s;
        // Remove first and last character to avoid trivial match
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }
}
