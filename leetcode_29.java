package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
public class Code {
    public static int divide(int dividend, int divisor) {
        boolean ispos = true;
        if(dividend == -2147483648 && divisor == -1) return 2147483647;
        if(dividend == -2147483648 && divisor == 1) return -2147483648;
        if(divisor == -2147483648){
            if(dividend == -2147483648) return 1;
            return 0;
        }
        
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)  ispos = false;
        String dividend_str = null;

        if(dividend < 0 && dividend != -2147483648){
            dividend_str = String.valueOf(-dividend);
        }
        else if(dividend == -2147483648){
            dividend_str = new String("2147483647");
        }
        else dividend_str = String.valueOf(dividend);
        
        if(divisor < 0) divisor = -divisor;
        int div = 0,ans = 0;
        Quotient_remainder tmp = null;
        for(int i = 0;i < dividend_str.length();i++){
            div = div * 10 + dividend_str.charAt(i) - '0';
            tmp = get_qt_re(div,divisor);
            div = tmp.remainder;
            ans = ans * 10 + tmp.quotient;
        }
        if(dividend == -2147483648){
            if(tmp.remainder + 1 == divisor) ans++;
        }
        if(ispos == false) ans = -ans;
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(divide(-2147483648,-1));
        sc.close();
    }  

    public static Quotient_remainder get_qt_re(int div,int divisor){
        int quotient = 0;
        while(div >=  divisor){
            div -= divisor;
            quotient++;
        }
        return new Quotient_remainder(quotient,div);
    }

}

class Quotient_remainder{
    int quotient;
    int remainder;
    public Quotient_remainder(int x,int y){
        quotient = x;
        remainder = y;
    }
}


