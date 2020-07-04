package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class Code {
    public static String simplifyPath(String path) {
        path = delmultiline(path);
        StringBuilder ans = new StringBuilder();
        int pos = 0;
        while(pos < path.length()){
            if(path.charAt(pos) == '/'){
                int num = getlinenum(path,pos);
                if(num == 0 || num > 2){
                    ans.append(path.charAt(pos));
                    pos++;
                    while(pos < path.length() && path.charAt(pos)!='/'){
                        ans.append(path.charAt(pos));
                        pos++;
                    }
                }
                else if(num == 1){
                    pos+=2;
                }
                else if(num == 2){
                    pos+=(num+1);
                    while(ans.length() > 0 && ans.charAt(ans.length() - 1) !='/'){
                        ans.deleteCharAt(ans.length()-1);
                    }
                    if(ans.length() > 0){
                        ans.deleteCharAt(ans.length()-1);
                    }
                }
            }
        }
        if(ans.length() == 0) ans.append('/');
        return ans.toString();   
    }
    public static int getlinenum(String path, int pos){
        int ans = 0;
        int prepos = pos;
        pos++;
        while(pos < path.length() && path.charAt(pos) != '/'){
            if(path.charAt(pos) == '.') ans++;
            pos++;
        }
        if(pos - prepos == ans) return ans;
        else return 0;
    }
    public static String delmultiline(String path){
    	StringBuilder ans = new StringBuilder();
        char c;
        for(int i = 0;i < path.length();i++){
            c = path.charAt(i);
            if(c == '/'){ 
                if(ans.length() == 0 || (ans.length() > 0 && ans.charAt(ans.length()-1) != '/')){
                    ans.append(c);
                }
            }
            else ans.append(c);
        }
        if(ans.length() > 1 && ans.charAt(ans.length() - 1) == '/'){
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "/...";
        System.out.println(simplifyPath(s));
    } 
}

