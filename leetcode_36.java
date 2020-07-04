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
    public static boolean isValidSudoku(char[][] board) {
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
        boolean ans = true;
        for(int i = 0; i < 9;i++){
            for(int j = 0;j < 9;j++){
                ans = ans && row[i][j] <= 1 && col[i][j] <= 1 && cube[i][j] <= 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        char[][] board =new char[][]{
              {'8','3','.','.','7','.','.','.','.'},
              {'6','.','.','1','9','5','.','.','.'},
              {'.','9','8','.','.','.','.','6','.'},
              {'8','.','.','.','6','.','.','.','3'},
              {'4','.','.','8','.','3','.','.','1'},
              {'7','.','.','.','2','.','.','.','6'},
              {'.','6','.','.','.','.','2','8','.'},
              {'.','.','.','4','1','9','.','.','5'},
              {'.','.','.','.','8','.','.','7','9'}
            };
        System.out.println(isValidSudoku(board));
    }  
}



