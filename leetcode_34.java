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
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return 0;
        return new int[]{find_left_target(nums,target),find_right_target(nums,target)};
    }
    public static find_left_target(int[] nums, int target){
        int lpos = 0,rpos = nums.length-1;
        if(nums[lpos] == target) return lpos;
        while(rpos - lpos > 1){
            int mid = (lpos + rpos) / 2;
            if(nums[mid] >= target) rpos = mid;
            else lpos = mid;
        }
        if(nums[lpos] == target) return lpos;
        if(nums[rpos] == target) return rpos;
        return -1;
    }
    public static find_right_target(int[] nums, int target){
        int lpos = 0,rpos = nums.length-1;
        if(nums[rpos] == target) return rpos;
        while(rpos - lpos > 1){
            int mid = (lpos + rpos) / 2;
            if(nums[mid] > target) rpos = mid;
            else lpos = mid;
        }
        if(nums[rpos] == target) return rpos;
        if(nums[lpos] == target) return lpos;
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] ans = searchRange(nums,8);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }  

    

}



