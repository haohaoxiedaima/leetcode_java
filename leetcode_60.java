package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Code {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0;i < n;i++){
            nums.add(i+1);
        }
        int count = k-1;
        String ans = new String();
        for(int i = 0;i < n;i++){
            int fac = getfactorial(n-i-1);
            int pos = count/fac;
            count = count%fac;
            ans = ans + nums.get(pos).toString();
            nums.remove(pos);
        }
        return ans;

    }
    public int getfactorial(int n){
        int ans = 1;
        for(int i = 1;i <= n;i++){
            ans = ans * i;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    } 
}

