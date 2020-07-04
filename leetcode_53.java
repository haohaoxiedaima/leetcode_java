package leetcode;
import java.util.Scanner;
public class Code {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int ans = pre;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] > pre + nums[i]){
                pre = nums[i];
            }
            else{
                pre = pre + nums[i];
            }
            if(ans < pre) ans = pre;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int x = sc.nextInt();
        System.out.println(isPalindrome(x));
        sc.close();

    }
    
}

