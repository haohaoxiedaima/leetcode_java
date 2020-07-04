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
    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int pmin = min_pos(nums);
        int ans1 = Bsearch(nums,0,pmin-1,target);
        int ans2 = Bsearch(nums,pmin,nums.length-1,target);
        if(ans1 == -1) return ans2;
        return ans1;
    }

    public static int min_pos(int[] nums){
        int lpos = 0,rpos = nums.length - 1;
        int ans = 0;
        if(nums[rpos] < nums[ans]) ans = rpos;
        while(rpos - lpos > 1){
            int mid = (lpos + rpos) / 2;
            if(nums[mid] < nums[ans]) ans = mid;
            if(nums[mid] > nums[lpos]) lpos = mid;
            else rpos = mid;
        }
        return ans;
    }
    public static int Bsearch(int[] nums,int lpos,int rpos,int target){
        if(lpos > rpos) return -1;
        if(nums[lpos] == target) return lpos;
        if(nums[rpos] == target) return rpos;
        while(rpos - lpos > 1){
            int mid = (lpos + rpos) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) lpos = mid;
            else rpos = mid;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
      
        System.out.println(search(nums,3));
    }  
}



