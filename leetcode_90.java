package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
public class Code {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] count = new int[](nums.length);
        int[] nums_nodup = new int[](nums.length);
        int pos0 = 0,pos1 = 0;
        while(pos0 < nums.length){
            int tmp = 1;
            int pos_tmp = pos0 + 1;
            while(pos_tmp < nums.length && nums[pos_tmp] == nums[pos0]){
                pos_tmp++;
                tmp++;
            }
            count[pos1] = tmp;
            nums_nodup[pos1] = nums[pos0];
            pos0 = pos_tmp;
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        f(ans,subset,0,nums_nodup,count,pos1);
        return ans;
    }
    public static void f(List<List<Integer>> ans,List<Integer> subset,int pos,int[] nums_nodup,int[] count,int lens){
        if(pos >= lens){
            List<Integer> tmp = new ArrayList<Integer>(subset);
            ans.add(tmp);
            return ;
        }
        for(int i = 0;i < count[pos];i++){
            for(int j = 0;j < i;j++){
                subset.add(nums_nodup[pos]);
            }
            f(ans,subset,pos+1,nums_nodup,count,lens);
            for(int j = 0;j < i;j++){
                subset.remove(subset.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};       
        System.out.println(subsetsWithDup(nums));
    } 
}



