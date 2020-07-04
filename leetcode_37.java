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
    public static void solveSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] cube = new int[9][9];
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(board[i][j] == '.') continue;
                row[i][board[i][j] - '1'] += 1;
                col[j][board[i][j] - '1'] += 1;
                int tmp = i / 3;
                cube[tmp*3 + j/3][board[i][j] - '1'] += 1;
            }
        }
        boolean ans = f(0,0,board,row,col,cube);
    }

    public static boolean f(int i,int j,char[][] board,int[][] row,int[][] col,int[][] cube){
        if(i == 9) return true;
        if(board[i][j] != '.'){
            if(j == 8) return f(i+1,0,board,row,col,cube);
            return f(i,j+1,board,row,col,cube);
        }
        int t = i / 3;
        List<Integer> legalnums = get_legal_nums(i,j,row,col,cube);
        for(int k = 0;k < legalnums.size();k++){
            int tmp = legalnums.get(k);
            board[i][j] = (char)(tmp + '1');
            row[i][tmp] += 1;
            col[j][tmp] += 1;
            cube[t*3 + j/3][tmp] += 1;
            boolean res;
            if(j == 8) res = f(i+1,0,board,row,col,cube);
            else res = f(i+1,0,board,row,col,cube);
            if(res == true) return true;
            row[i][tmp] -= 1;
            col[j][tmp] -= 1;
            cube[t*3 + j/3][tmp] -= 1;
        }
        return false;
    }

    public static List<Integer> get_legal_nums(int i,int j,int[][] row,int[][] col,int[][] cube){
        List<Integer> ans = new ArrayList<Integer>();
        int tmp = i / 3;
        for(int num = 0;num < 9;num++){
            if(row[i][num] < 1 && col[j][num] < 1 && cube[tmp*3 + j/3][num] < 1){
                ans.add(num);
            } 
        }
        return ans;
    }
    public static void main(String[] args) {
        char[][] board =new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
          };
        solveSudoku(board);
        System.out.println(board);
    }  
}



