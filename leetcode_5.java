package leetcode;
import java.util.Scanner;
import java.util.HashSet;
public class Code {
    public static String longestPalindrome(String s) {
        if(s.length() == 0){
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        String rs = sb.reverse().toString();
        int[][] dp = new int[1000][1000];
        int res = 0;
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) != rs.charAt(j)){
                    dp[i][j] = 0;
                }
                else{
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                }
                if(dp[i][j] > res && (i - res + 1 + j) == s.length() - 1){
                    res = dp[i][j];
                    pos = i;
                }
            }
        }
        return s.substring(pos - res + 1,pos + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        String s = sc.next();
        System.out.println(longestPalindrome(s));
        sc.close();
    }
}

