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
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        List<Integer> Node = new ArrayList<Integer>();
        f(ans,Node,candidates,target,0,0);
        return ans;
    }

    public static void f(List<List<Integer>> ans,List<Integer> Node,int[] candidates,int target,int pos,int val){
        if(pos > Node.size() - 1) return;
        while(val < target){
            f(ans,Node,candidates,target,pos+1,val);
            Node.add(candidates[pos]);
            val += candidates[pos];
        }
        if(val == target){
            List<Integer> tmp = new ArrayList<Integer>(Node);
            ans.add(tmp);
        }
        while(!Node.empty() && Node.get(Node.size() - 1) == candidates[pos]){
            Node.remove(Node.size() - 1);
        }       
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        System.out.println(combinationSum(candidates,7));
    }  
}



