package leetcode;
import java.util.Scanner;
public class Code {
    public static boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0) return true;
        if(p.length() == 0) return false;
        if(p.length() == 1){
            if(s.length() == 1){
                if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') return true;
            }
            return false;
        }
        if(p.charAt(1) != '*'){
            if(s.length() == 0) return false;
            if(p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) return isMatch(s.substring(1,s.length()),p.substring(1,p.length()));
            return false;
        }
        boolean ans = isMatch(s,p.substring(2,p.length()));
        char tmp = p.charAt(0);
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == tmp || tmp == '.'){
                if(isMatch(s.substring(i+1,s.length()),p.substring(2,p.length()))){
                    ans = true;
                    break;
                }
            }
            else {break;}
        }
        return ans;       
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String s = sc.next();
        String p = sc.next();
        System.out.println(isMatch(s,p));
        sc.close();

    }
    
}

