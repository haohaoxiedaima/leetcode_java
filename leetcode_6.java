package leetcode;
import java.util.Scanner;
public class Code {
    public String convert(String s, int numRows) {
        int lens = s.length();
        int node_char_num = numRows*2 - 2;
        int node_width = numRows - 1;
        int node_num = lens / node_char_num;
        int rest_char_num = lens % node_char_num;
        int rest_width;
        if(rest_char_num == 0){
            rest_width = 0;
        }
        else if(rest_char_num <= numRows){
            rest_width = 1;
        }
        else{
            rest_width = 1 + rest_char_num - numRows;
        }
        int width = node_width * node_num + rest_width;
        char[][] ans = new char[numRows][width];
        int i = 0, j = 0,pos = 0;
        while(pos < lens){
            while(i < numRows && pos < lens){
                ans[i][j] = s.charAt(pos);
                pos++;i++;
            }
            while(i > 0 && pos < lens){
                i--;j++;
                ans[i][j] = s.charAt(pos);
                pos++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(i = 0; i < numRows;i++){
            for(j = 0;j < width;j++){
                if(ans[i][j] != 0){
                    builder.append(ans[i][j]);
                }
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
        String s = sc.next();
        System.out.println(convert(s));
        sc.close();
    }
}

