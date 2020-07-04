package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class Code {
    public int removeElement(int[] nums, int val) {
        int p = 0,q = 0;
        while(q < nums.length){
            if(nums[q] != val){
                nums[p] = nums[q];
                p++;q++;
            }
            else{
                q++;
            }
        }
        return p;
    }
}



