package leetcode;
import java.util.Scanner;
public class Code {
    public static boolean canJump(int[] nums) {
        int pre = 0;
        for(int i = 0; i < nums.length;i++){
            if(pre >= i){
                if(pre < i + nums[i]){
                    pre = i + nums[i];
                }
            }
        }
        return pre >= nums.length() - 1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(canJump(num));
    } 
}

