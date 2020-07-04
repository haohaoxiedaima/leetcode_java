package leetcode;
import java.util.Scanner;
public class Code {
    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        int[] m = new int[4];
        m[0] = num/1000;num = num%1000;
        m[1] = num/100;num = num%100;
        m[2] = num/10;num = num%10;
        m[3] = num;
        int i;
        for(i = 0;i < m[0];i++){
            ans.append("M");
        }
        if(m[1] == 9) ans.append("CM");
        if(m[1] == 4) ans.append("CD");
        if(m[1] >= 5 && m[1] <= 8){
            ans.append("D");m[1] -= 5;
        }
        for(i = 0;i < m[1];i++){
            if(m[1] == 4 || m[1] == 9) break;
            ans.append('C');
        }
        if(m[2] == 9) ans.append("XC");
        if(m[2] == 4) ans.append("XL");
        if(m[2] >= 5 && m[2] <= 8){
            ans.append("L");m[2] -= 5;
        }
        for(i = 0;i < m[2];i++){
            if(m[2] == 4 || m[2] == 9) break;
            ans.append('X');
        }
        if(m[3] == 9) ans.append("IX");
        if(m[3] == 4) ans.append("IV");
        if(m[3] >= 5 && m[3] <= 8){
            ans.append("V");m[3] -= 5;
        }
        for(i = 0;i < m[3];i++){
            if(m[3] == 4 || m[3] == 9) break;
            ans.append('I');
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int m = sc.nextInt();
        System.out.println(intToRoman(m));
    }
    
}

