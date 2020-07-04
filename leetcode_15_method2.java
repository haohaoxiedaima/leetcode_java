package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
public class Code {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) return ans;
        for(int i = 0;i < nums.length;i++){
            int j = i + 1,k = nums.length - 1;
            while(j < k){
                int tmp = nums[i] + nums[j] + nums[k];
                if(tmp < 0) j++;
                if(tmp > 0) k--;
                if(tmp == 0){
                    boolean tag = false;
                    if(isfirst(i,nums) && isfirst(j,nums) && isfirst(k,nums)) tag = true;
                    if(isfirst(i,nums) && j == i+1 && isfirst(k,nums)) tag = true;
                    if(isfirst(i,nums) && isfirst(j,nums) && k == j+1) tag = true;
                    if(isfirst(i,nums) && j == i+1 && k == j+1) tag = true;
                    if(tag){
                        List<Integer> tmps = new ArrayList<>();
                        tmps.add(nums[i]);tmps.add(nums[j]);tmps.add(nums[k]);                                    
                        ans.add(tmps);
                    }
                    j++;k--;
                }
            }
        }
        return ans;
    }
    public static boolean isfirst(int n,int[] nums){
        if(n == 0) return true;
        return nums[n-1] < nums[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        sc.close();
    }  
}

