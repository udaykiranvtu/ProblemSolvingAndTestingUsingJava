class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;   // highest altitude reached
        int currentAltitude = 0; // current altitude starting at 0
        
        for (int g : gain) {
            currentAltitude += g;          // update altitude
            maxAltitude = Math.max(maxAltitude, currentAltitude); // track max
        }
        
        return maxAltitude;
    }
}
