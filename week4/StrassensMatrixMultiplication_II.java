class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                
                // Define the boundaries for the valid block
                int rMin = Math.max(0, i - k);
                int rMax = Math.min(m - 1, i + k);
                int cMin = Math.max(0, j - k);
                int cMax = Math.min(n - 1, j + k);
                
                // Sum all elements within the valid bounds
                for (int r = rMin; r <= rMax; r++) {
                    for (int c = cMin; c <= cMax; c++) {
                        sum += mat[r][c];
                    }
                }
                
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}
