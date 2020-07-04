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
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> Node = new ArrayList<Integer>();
        Arrays.sort(candidates);
        f(ans,Node,candidates,target,0,0);
        return ans;
    }

    public static void f(List<List<Integer>> ans,List<Integer> Node,int[] candidates,int target,int pos,int val){
        if(pos >= candidates.length) return ;
        if(val >= target) return ;
        f(ans,Node,candidates,target,pos+1,val);
        Node.add(candidates[pos]);
        val += candidates[pos];
        if(val < target) f(ans,Node,candidates,target,pos+1,val);
        if(val == target){
            List<Integer> tmp = new ArrayList<Integer>(Node);
            if(!ans.contains(tmp)) ans.add(tmp);
        }
        Node.remove(Node.size() - 1);
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates,8));
    }  
}



