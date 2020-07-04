package leetcode;
import java.util.Scanner;
public class Code {
    public int maxArea(int[] height) {
        int p1 = 0, p2 = height.length - 1;
        int ans = 0;
        while(p1 != p2){
            if(height[p1] < height[p2]){
                int tmp = height[p1] * (p2 - p1);
                if(ans < tmp) ans = tmp;
                p1++;
            }
            else{
                int tmp = height[p2] * (p2 - p1);
                if(ans < tmp) ans = tmp;
                p2--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in); 
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    
}

