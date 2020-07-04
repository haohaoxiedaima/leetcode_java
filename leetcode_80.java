package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
public class Code {
    public int removeDuplicates(int[] nums) {
        int len = 0,pos = 0,prenum = 0;
        while(pos < nums.length){
            if(len == 0){
                len++;pos++;prenum++;
            }
            else{
                if(nums[pos] == nums[len-1]){
                    if(prenum >= 2){
                        prenum++;pos++;
                    }
                    else{
                        prenum++;
                        nums[len] = nums[pos];
                        pos++;len++;
                    }
                }
                else{
                    nums[len] = nums[pos];
                    pos++;len++;
                    prenum = 1;
                }
            }
        }
        return len;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    } 
}

