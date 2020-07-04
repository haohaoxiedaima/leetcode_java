package leetcode;
import java.util.Scanner;
import java.util.HashSet;
public class Code {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 1){
            return 1;
        }
        String s1 = s.substring(0,s.length()/2);
        String s2 = s.substring(s.length()/2,s.length());
        int len1 = lengthOfLongestSubstring(s1),len2 = lengthOfLongestSubstring(s2);
        int len3 = merge(s1,s2);
        if(len1 < len2){len1 = len2;}
        if(len1 < len3){len1 = len3;}
        return len1;
    }
    public static int merge(String s1,String s2){
    	HashSet<String> set = new HashSet<String>();
        if(s1.charAt(s1.length()-1) == s2.charAt(0)){
            return 0;
        }
        set.add(s1.substring(s1.length()-1,s1.length()));
        set.add(s2.substring(0,1));
        int i = s1.length()-2,j = 1;
        while(i >= 0 || j < s2.length()){
            int tag0 = 0, tag1 = 0;
            if(i < 0){
                tag0 = 1;
            }else{
                if(set.contains(s1.substring(i,i+1))){
                    tag0 = 1;
                }
                else{
                    set.add(s1.substring(i,i+1));
                    i--;
                }
            }
            if(j >= s2.length()){
                tag1 = 1;
            }else{
                if(set.contains(s2.substring(j,j+1))){
                    tag1 = 1;
                }
                else{
                    set.add(s2.substring(j,j+1));
                    j++;
                }
            }
            if(tag0 == 1 && tag1 == 1){
                break;
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        String s = sc.next();
        System.out.println(s);
        System.out.println(lengthOfLongestSubstring(s)); 
        sc.close();
    }
}

