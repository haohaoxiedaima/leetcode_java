package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
public class Code {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int p1 = 0;
        while(p1 <= p2){
            if(nums[p1] == 1) p1++;
            else if(nums[p1] == 0 && p1 == p0){
                p0++;p1++;
            }
            else if(nums[p1] == 0){
                nums[p1] = 1;
                nums[p0] = 0;
            }
            else if(nums[p1] == 2){
                nums[p1] = nums[p2];
                nums[p2] = 2;
                p2--;
            }
        }
    }
    public static void main(String[] args) {
        
    } 
}

