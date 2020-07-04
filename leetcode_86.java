package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
public class Code {
    public ListNode partition(ListNode head, int x) {
        ListNode pre = null;
        ListNode aft = null;
        ListNode pre_head = null;
        ListNode aft_head = null;
        while(head != null){
            if(head.val < x){
                ListNode tmp = new ListNode(head.val);
                if(pre == null){
                    pre = tmp;
                    pre_head = pre;
                }
                else{
                    pre.next = tmp;
                    pre = pre.next;
                }
            }
            else{
                ListNode tmp = new ListNode(head.val);
                if(aft == null){
                    aft = tmp;
                    aft_head = aft;
                }
                else{
                    aft.next = tmp;
                    aft = aft.next;
                }
            }
            head = head.next;
        }
        if(pre == null) return aft_head;
        pre.next = aft_head;
        return pre_head;
    }
}



