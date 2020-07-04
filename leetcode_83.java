package leetcode;
import java.util.Scanner;
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class Code {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode tail = head;
        ListNode p = head.next;
        while(p != null){
            if(p.val == tail.val){
                p = p.next;
            }
            else{
                tail.next = p;
                p = p.next;
                tail = tail.next;
            }
        }
        if(tail != null) tail.next = null;
        return head;
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

