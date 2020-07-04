package leetcode;
import java.util.Scanner;
import Arrays;
public class Code {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>{
            public int compare(int[] n1,int[] n2){
                return n1[0] - n2[0];
            }
        });
        return intervals;
    }
    public static void main(String[] args) {
        int[][] intervals= new int[][]{[[1,3],[2,6],[8,10],[15,18]]};
        System.out.println(merge(intervals));
    } 
}

