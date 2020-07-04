package leetcode;
import java.util.Scanner;
public class Code {
    public static boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int lpos = 0,rpos = nums.length;
        int maxpos = max_pos(nums,0,rpos);
        int ans1 = Bsearch(nums,0,maxpos+1,target);
        int ans2 = Bsearch(nums,maxpos+1,rpos,target);
        if(ans1 == -1 && ans2 == -1) return false;
        return true; 

    }
    public static int max_pos(int[] nums, int lpos,int rpos){
        if(rpos - lpos <= 1) return lpos;
        int mid = (lpos+rpos)/2;
        if(nums[mid] > nums[lpos]) return max_pos(nums,mid,rpos);
        else if(nums[mid] < nums[lpos]) return max_pos(nums,lpos,mid);
        else{
            return max_pos(lpos+1,rpos);
        }    
    }
    public static int Bsearch(int[] nums,int lpos,int rpos,int target){
        if(lpos - rpos >= 0) return -1;
        int mid = (lpos+rpos)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target) return Bsearch(nums,mid+1,rpos,target);
        return Bsearch(nums,lpos,mid,target);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,1,1};
        System.out.println(search(nums,3));
    }
    
}

