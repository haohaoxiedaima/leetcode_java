package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Code {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 && j == 0) dp[i][j] = grid[0][0];
                else if(i == 0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else if(j == 0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else{
                    int min = dp[i-1][j];
                    if(min > dp[i][j-1]) min = dp[i][j-1];
                    dp[i][j] = min + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        
    } 
}

