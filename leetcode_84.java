package leetcode;
import java.util.*;
public class Code {
	public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<Integer>();
        int ans = 0;
        for(int i = 0;i < heights.length;i++){
            if(stk.empty() || heights[stk.peek()] <= heights[i]){
                stk.push(i);
            }
            else{
                while(!stk.empty() && heights[stk.peek()] > heights[i]){
                    int tmp = heights[stk.pop()];
                    int left = 0;
                    if(!stk.empty()) left = stk.peek() + 1;
                    int right = i-1;
                    tmp = tmp*(right - left + 1);
                    if(tmp > ans) ans = tmp;
                }
                stk.push(i);
            }
        }
        while(!stk.empty()){
            int tmp = heights[stk.pop()];
            int left = 0;
            if(!stk.empty()) left = stk.peek() + 1;
            int right = heights.length - 1;
            tmp = tmp*(right - left + 1);
            if(tmp > ans) ans = tmp;
        }
        return ans;       
    }
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    
}

