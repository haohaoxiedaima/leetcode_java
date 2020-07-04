package leetcode;
import java.util.Scanner;
public class Code {
    public static double myPow(double x, int n) {
        long ln = n;
        long pos_ln = ln >= 0?ln:-ln;
        double ans = fastpow(x,pos_ln);
        if(ln < 0) ans = 1/ans;
        return ans;
        
    }
    public static double fastpow(double x, long ln){
        if(ln == 0){
            return 1.0;
        }
        double half = fastpow(x, ln/2);
        if(ln % 2 == 0){
            return half * half;
        }
        else{
            return half * half * x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(myPow(x,n));
        sc.close();
    }
    
}

