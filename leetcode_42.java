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
    public static int trap(int[] height) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i = 0;i < height.length;i++){
            set.add(height[i]);
        }
        Iterator<Integer> iter = set.iterator();
        int pre = 0;
        int ans = 0;
        while(iter.hasNext()){
        	int tmp = iter.next();
            int lpos = -1,rpos = 0;
            while(rpos < height.length){
                if(height[rpos] >= tmp){
                    if(lpos != -1) ans = ans + (rpos - lpos - 1)*(tmp - pre);
                    lpos = rpos;
                }
                rpos++;
            }
            pre = tmp;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] candidates = new int[]{10527,740,9013,1300,29680,4898};
        System.out.println(trap(candidates));
    }  
}



