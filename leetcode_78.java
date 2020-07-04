package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
public class Code {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        f(nums,0,ans,subset);
        return ans;

    }
    public static void f(int[] nums,int pos,List<List<Integer>> ans,List<Integer> subset){
        if(pos >= nums.length){
            List<Integer> tmp = new List<Integer>(subset);
            ans.add(tmp);
        }
        f(nums,pos+1,ans,subset);
        subset.add(nums[pos]);
        f(nums,pos+1,ans,subset);
        subset.remove(subset.size()-1);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    } 
}

