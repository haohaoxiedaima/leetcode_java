package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class Code {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head;
        ListNode pnext = p.next;
        ListNode pm = head;
        ListNode pn = head;
        ListNode pm_pre = head;
        ListNode pn_below = head;
        for(int i = 1;i <= n+1;i++){
            if(i == m-1) pm_pre = p;
            if(i == m) pm = p;  
            if(i == n) pn = p;  
            if(i == n+1) pn_below = p;
            if(i < m || i >= n){
                p = p == null?null:p.next; 
                pnext = pnext == null?pnext:pnext.next;
                continue;
            }     
            ListNode p_tmp = pnext;
            ListNode pnext_tmp = pnext == null?pnext:pnext.next;
            pnext.next = p;
            p = p_tmp;
            pnext = pnext_tmp;
        }
        //if(m == n) return head;
        if(m > 1){
            pm_pre.next = pn;
        }      
        pm.next = pn_below;
        if(m > 1) return head;
        return pn;
    }
    public static void main(String[] args) {       
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        head.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode ans = reverseBetween(head,2,4);
        ListNode p = ans;
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    } 
}



