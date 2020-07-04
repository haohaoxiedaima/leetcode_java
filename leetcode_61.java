package leetcode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class Code {
    public static ListNode rotateRight(ListNode head, int k) {
        int len = getlen(head);
        if(len == 0) return head;
        k = k % len;
        if(k == 0) return head; 
        ListNode p = head;
        for(int i = 0;i < len - 1;i++){
            p = p.next;
        }
        p.next = head;
        ListNode ans = newhead(head,k,len);
        return ans;
    }
    public static int getlen(ListNode head){
        int ans = 0;
        ListNode p = head;
        while(p != null){
            ans++;
            p = p.next;
        }
        return ans;
    }
    public static ListNode newhead(ListNode head,int k,int len){
        ListNode ans = head;
        ListNode tail = null;
        for(int i = 0;i < len - k;i++){
            ans = ans.next;
            if(i == len - k - 1){
                tail = ans;
            }
        }
        tail.next = null;
        return ans;
    }
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;
        ListNode ans = rotateRight(a1,2);
        while(ans != null){
            print(ans.val);
            ans = ans.next;
        }
    } 
}

