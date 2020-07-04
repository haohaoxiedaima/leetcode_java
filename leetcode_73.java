package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
public class Code {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return ;
        if(matrix[0].length == 0) return ;
        Set<Integer> col = new HashSet<Integer>();
        Set<Integer> row = new HashSet<Integer>();
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    col.add(i);
                    row.add(j);
                }
            }
        }
        Iterator<Integer> itor = col.iterator;
        while(itor.hasNext()){
            int n = itor.next();
            for(int i = 0;i < matrix[0].length;i++){
                matrix[n][i] = 0;
            }
        }
        Iterator<Integer> itr = row.iterator;
        while(itr.hasNext()){
            int n = itr.next();
            for(int i = 0; i < matrix.length;i++){
                matrix[i][n] = 0;
            }
        }        
    }
    public static void main(String[] args) {
        
    } 
}

