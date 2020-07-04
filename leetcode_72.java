package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Code {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0) return len2;
        if(len2 == 0) return len1;
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len2;i++){
            dp[0][i] = i;
        }
        for(int i = 0; i <= len2;i++){
            dp[i][0] = i;
        }
        for(int i = 1;i <= len1;i++){
            for(int j = 1;j <= len2;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    int n1 = dp[i-1][j-1];
                    int n2 = dp[i][j-1] + 1;
                    int n3 = dp[i-1][j] + 1;
                    if(n2 < n1) n1 = n2;
                    if(n3 < n1) n1 = n3;
                    dp[i][j] = n1;
                }
                else{
                    int n1 = dp[i-1][j-1] + 1;
                    int n2 = dp[i][j-1] + 1;
                    int n3 = dp[i-1][j] + 1;
                    if(n2 < n1) n1 = n2;
                    if(n3 < n1) n1 = n3;
                    dp[i][j] = n1;
                }
            }
        }
        return dp[len1][len2];
    }
    public static void main(String[] args) {
        System.out.prinln(minDistance("horse","ros"));
    } 
}

