package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
public class Code {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        if(n == 0){
            ans.add(0);
            return ans;
        }   
        ans.add(0);
        ans.add(1);
        for(int i = 1;i < n;i++){
            int pos = ans.size() - 1;
            while(pos >= 0){
                int tmp = (int)(Math.pow(2,i)) + ans.get(pos);
                pos--;
                ans.add(tmp);
            }
        }
        return ans;
    }
}



