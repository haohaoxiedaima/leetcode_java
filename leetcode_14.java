package leetcode;
import java.util.Scanner;
public class Code {
    public static String longestCommonPrefix(String[] strs) {
        String ans = new String();
        if(strs.length == 0) return ans;
        if(strs.length == 1) return strs[0];
        ans = longestCommonPrefix_Two_Str(strs[0],strs[1]);
        for(int i = 2; i < strs.length;i++){
            ans = longestCommonPrefix_Two_Str(ans,strs[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String[] m = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(m));
        sc.close();
    }
    public static String longestCommonPrefix_Two_Str(String s1, String s2){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s1.length() && i < s2.length();i++){
            if(s1.charAt(i) == s2.charAt(i)){
                str.append(s1.charAt(i));
            }
            else break;
        }
        return str.toString();
    }
    
}

