package leetcode;
import java.util.Scanner;
public class Code {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1,num2,numpre = 0;
        ListNode res = null;
        ListNode pnode = null;
        while(l1 != null || l2 != null || numpre == 1){
            num1 = 0;num2 = 0;
            if(l1 != null){
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                num2 = l2.val;
                l2 = l2.next;
            }
            int tmp = num1 + num2 + numpre;
            if(tmp > 9){
                tmp -= 10;numpre = 1;
            }
            else{
                numpre = 0;
            }
            ListNode mnode = new ListNode(tmp);
            if(res == null){
                pnode = mnode;
                res = pnode;
            }
            else{
                pnode.next = mnode;
                pnode = mnode;
            }           
        }
        return res;        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode node = new ListNode(sc.nextInt());
        ListNode pnode = node;
        for(int i = 0; i < 5; i++){
            pnode.next = new ListNode(sc.nextInt());
            pnode = pnode.next;
        }
        ListNode res = addTwoNumbers(node,node);
        while(res != null){
            System.out.print(res.val);
            res = res.next;
        }       
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x;}
}
