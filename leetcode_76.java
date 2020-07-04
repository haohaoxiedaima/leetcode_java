package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
public class Code {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        f(ans,comb,1,n,k);
        return ans;
    }
    public static void f(List<List<Integer>> ans,List<Integer> comb,int num,int n,int k){
        if(comb.size() >= k){
            List<Integer> tmp = new List<Integer>(comb);
            ans.add(tmp);
        }
        else{
            if(num > n) return ;
            comb.add(num);
            f(ans,comb,num+1,n,k);
            comb.remove(comb.size() - 1);
            f(ans,comb,num+1,n,k);
        }
    }
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    } 
}

