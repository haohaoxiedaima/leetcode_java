package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class Code {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int num = 0;
        ListNode p = head;
        while(p != null){
            num++;p = p.next;
        }
        n = num - n;
        if(head == null) return head;
        if(n == 0) return head.next;
        p = head;
        ListNode q = head;
        while(n > 0){
            p = p.next;
            if(n > 1) q = q.next;
        }
        q.next = p.next;
        return head;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("helloworld");
        sc.close();
    }  
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


