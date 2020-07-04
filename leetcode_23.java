package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class Code {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = l1,p1 = l1,p2 = l2,last = l1;
        if(l1.val < l2.val) p1 = l1.next;
        else{
            head = l2;p2 = l2.next;last = l2;
        }
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                last.next = p1;
                last = p1;
                p1 = p1.next;
            }
            else{
                last.next = p2;
                last = p2;
                p2 = p2.next;
            }
        }
        if(p1 == null){
            last.next = p2;
        }
        else{
            last.next = p1;
        }
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if(len == 0) return new ListNode();
        if(len == 1) return lists[0];
        ListNode ans = mergeTwoLists(lists[0],lists[1]);
        for(int i = 2;i < len;i++){
            ans = mergeTwoLists(ans,lists[i]);
        }
        return ans;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


