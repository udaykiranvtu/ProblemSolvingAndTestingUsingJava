import java.io.*;
import java.util.*;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        
        // Convert List<List<Integer>> to a standard 2D array for easier manipulation
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = matrix.get(i).get(j);
            }
        }
        
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            // Extract the current layer into a 1D list
            List<Integer> layerElements = new ArrayList<>();
            int r1 = layer, r2 = m - 1 - layer;
            int c1 = layer, c2 = n - 1 - layer;
            
            // Top side (left to right)
            for (int c = c1; c <= c2; c++) layerElements.add(mat[r1][c]);
            // Right side (top to bottom, excluding duplicate corner)
            for (int row = r1 + 1; row <= r2; row++) layerElements.add(mat[row][c2]);
            // Bottom side (right to left, excluding duplicate corner)
            for (int c = c2 - 1; c >= c1; c--) layerElements.add(mat[r2][c]);
            // Left side (bottom to top, excluding corners)
            for (int row = r2 - 1; row > r1; row--) layerElements.add(mat[row][c1]);
            
            int len = layerElements.size();
            int effectiveRotations = r % len; // Avoid redundant full rotations
            
            // Rotate the elements anti-clockwise by shifting indices
            List<Integer> rotatedLayer = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                rotatedLayer.add(layerElements.get((i + effectiveRotations) % len));
            }
            
            // Put the rotated elements back into the matrix
            int idx = 0;
            // Top side
            for (int c = c1; c <= c2; c++) mat[r1][c] = rotatedLayer.get(idx++);
            // Right side
            for (int row = r1 + 1; row <= r2; row++) mat[row][c2] = rotatedLayer.get(idx++);
            // Bottom side
            for (int c = c2 - 1; c >= c1; c--) mat[r2][c] = rotatedLayer.get(idx++);
            // Left side
            for (int row = r2 - 1; row > r1; row--) mat[row][c1] = rotatedLayer.get(idx++);
        }
        
        // Print the resultant matrix row by row
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]);
                if (j < n - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                matrixRowItems.add(Integer.parseInt(matrixRowTempItems[j]));
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);
        bufferedReader.close();
    }
}
