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
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> node = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            node.add(nums[i]);
        }
        ans.add(node);
        int pos = findpos(nums);
        while(pos > -1){
            rev(nums,pos);
            setpos(nums,pos);
            node = new ArrayList<Integer>();
            for(int i = 0;i < nums.length;i++){
                node.add(nums[i]);
            }
            ans.add(node);
            pos = findpos(nums);
        }
        return ans;
    }
    public static int findpos(int[] nums){
        int pos = nums.length - 1;
        while(pos > 0){
            if(nums[pos-1] < nums[pos]) return pos - 1;
            pos--;
        }
        return -1;
    }
    public static void rev(int[] nums,int pos){
        int tmp;
        int rev_pos = nums.length-1;
        pos++;
        while(pos < rev_pos){
            tmp = nums[pos];
            nums[pos] = nums[rev_pos];
            nums[rev_pos] = tmp;
            pos++;rev_pos--;
        }
    }
    public static void setpos(int[] nums,int pos){
        int m = pos + 1;
        while(m < nums.length){
            if(nums[m] > nums[pos]){
                int tmp = nums[m];
                nums[m] = nums[pos];
                nums[pos] = tmp;
                break;
            }
            m++;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(permute(nums));
    }
}