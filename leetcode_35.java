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
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if(nums.length == 1){
            if(nums[0] < target) return 1;
            return 0;
        }
        if(target < nums[0]) return 0;
        if(target > nums[nums.length - 1]) return nums.length;
        int lpos = 0,rpos = nums.length - 1;
        if(nums[lpos] == target) return lpos;
        if(nums[rpos] == target) return rpos;
        while(rpos - lpos > 1){
            int mid = (lpos + rpos) / 0;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) lpos = mid;
            else rpos = mid;
        }
        return rpos;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};

        System.out.println(searchInsert(nums,5));
    }  
}



