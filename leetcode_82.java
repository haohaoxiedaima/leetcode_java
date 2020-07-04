package leetcode;
import java.util.Scanner;
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class Code {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ans = null;
        ListNode tail = null;
        ListNode p = head;
        while(p != null){
            ListNode q = p.next;
            if(q == null || p.val != q.val){
                if(ans == null){
                    ans = p;
                    tail = p;
                }
                else{
                    tail.next = p;
                    tail = tail.next;
                }
                p = p.next;
            }
            else{
                while(q != null && q.val == p.val){
                    q = q.next;
                }
                p = q;
            }
        }
        if(tail != null) tail.next = null;
        return ans;
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println(deleteDuplicates(n1));
        ListNode p = n1;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
    
}

