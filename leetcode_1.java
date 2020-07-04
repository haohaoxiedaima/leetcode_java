import java.util.Scanner;
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int pos1,pos2;
        int[] res = new int[2];
        for(pos1 = 0; pos1 < nums.length; pos1++){
            for(pos2 = pos1 + 1; pos2 < nums.length; pos2++){
                if(nums[pos1] + nums[pos2] == target){
                    res[0] = pos1;
                    res[1] = pos2;
                    return res;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[6];
        int target;
        int[] res = new int[2];
        Scanner sc = new Scanner(System.in);
        for(int i = 0;i < 6;i++){
            nums[i] = sc.nextInt();
        }
        target = sc.nextInt();
        res = twoSum(nums,target);
        System.out.println(res[0] + "  " + res[1]);
    }
}