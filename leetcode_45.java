package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
public class Code {
    public static int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int[] ans = new int[nums.length];
        return f(nums,ans,0);

    }
    public static int f(int[] nums,int[] ans,int pos){
        if(pos >= nums.length - 1) return 0;
        if(ans[pos] > 0) return ans[pos];
        if(nums[pos] == 0){
            ans[pos] = -1;
            return -1;
        }
        int tmp = -1;
        for(int i = nums[pos];i >= 1;i--){
            int k = f(nums,ans,pos+i);
            if(k == -1) continue;
            if(tmp == -1 || k < tmp) tmp = k;
            if(tmp == 0 || tmp == 1) break;
        }
        if(tmp == -1) ans[pos] = -1;
        else ans[pos] = tmp + 1;
        return ans[pos];
    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,0,1,4};
        System.out.println(jump(nums));
    } 
}



