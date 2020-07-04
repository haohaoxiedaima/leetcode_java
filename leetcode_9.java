package leetcode;
import java.util.Scanner;
public class Code {
    public static boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int rev_x = 0;
        while(x > rev_x){
            int tmp = x%10;
            rev_x = rev_x*10+tmp;
            x /= 10;
        }
        return (x == rev_x) || (rev_x/10 == x);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int x = sc.nextInt();
        System.out.println(isPalindrome(x));
        sc.close();

    }
    
}

