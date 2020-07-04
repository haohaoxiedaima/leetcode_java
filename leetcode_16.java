package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
public class Code {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int dis = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++){
            int j = i + 1,k = nums.length - 1;
            while(j < k){
                int tmp = nums[i] + nums[j] + nums[k] - target;
                if(Math.abs(tmp) < dis){
                    dis = Math.abs(tmp);
                    ans = nums[i] + nums[j] + nums[k];
                }
                if(tmp < 0) j++;
                if(tmp > 0) k--;
                if(tmp == 0) return target;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
        sc.close();
    }  
}

