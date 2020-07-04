package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
public class Code {
    public static int firstMissingPositive(int[] nums) {
        boolean ans_one = true;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1) ans_one = false;
        }
        if(ans_one) return 1;

        for(int i = 0;i < nums.length;i++){
            if(nums[i] <= 0 || nums[i] >= nums.length+1) nums[i] = 1;
        }
        for(int i = 0;i < nums.length;i++){
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])]-1);
        }
        int ans = nums.length + 1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > 0) return i+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        System.out.println(firstMissingPositive(candidates));
    }  
}



