package leetcode;
import java.util.Scanner;
import java.util.HashSet;
public class Code {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0;
        int ans = 0;
        while(i < s.length() && j < s.length()){
            while(j < s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            if(ans < set.size()){
                ans = set.size();
            }
            set.remove(s.charAt(i));
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        String s = sc.next();
        System.out.println(lengthOfLongestSubstring(s));
        sc.close();
    }
}

