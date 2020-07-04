package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
public class Code {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        for(int k = 0;k < nums.length;k++){
            if(!m.containsKey(nums[k])){
                m.put(nums[k],1);
            }
            else{
                m.put(nums[k],m.get(nums[k]) + 1);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 3) return ans;
        for(int i = 0; i < nums.length - 2;i++){
            for(int j = i + 1; j < nums.length - 1;j++){
                int x = nums[i] + nums[j];
                if(x > 0) break;
                x = 0 - x;
                if(m.containsKey(x)){
                    boolean tag = true;
                    int x_num = m.get(x);x_num--;
                    if(x == nums[i]) x_num--;
                    if(x == nums[j]) x_num--;
                    tag = tag & (x_num >= 0);
                   // tag = tag & ((x > nums[i] && x > nums[j]) || (x == nums[j] && nums[j-1] < nums[j]) || (x == nums[i] && (i == 0 || nums[i-1] < nums[i]) && j == i+1));
                    tag =  tag & (x >= nums[j] && ((nums[i] == nums[j] && (j == i+1 && (i == 0 || nums[i-1] < nums[i]))) || (nums[i] < nums[j] && ((i == 0 || nums[i-1] < nums[i]) && nums[j-1] < nums[j]))));
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);tmp.add(nums[j]);tmp.add(x);                                    
                    if(tag){
                        ans.add(tmp);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        sc.close();
    }  
}

