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
    public static void nextPermutation(int[] nums) {
        if(nums.length > 1){
            int pos = nums.length - 1;
            int prepos = pos - 1;
            while(prepos >= 0){
                if(nums[prepos] < nums[pos]) break;
                prepos--;pos--;
            }
            if(prepos < 0) Arrays.sort(nums);
            else{
                for(int i = pos + 1;i < nums.length;i++){
                    if(nums[i] > nums[prepos]) pos = i;
                }
                int tmp = nums[prepos];
                nums[prepos] = nums[pos];
                nums[pos] = tmp;
                Arrays.sort(nums,prepos+1,nums.length);
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);       
        System.out.println(nums);
    }  
}



