package code;

/**21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        Solution_21 s = new Solution_21();
        ListNode l3 = s.mergeTwoLists(l1,l2);
        for (ListNode l=l3;l!=null;l=l.next){
            System.out.println(l.val);
        }

    }


}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null){//考虑空链表
            if(l1==null&&l2!=null){
                return l2;
            }else{
                return l1;
            }

        }
        ListNode l3=l1;
        boolean flag=false;
        for(ListNode l=l3;;l=l.next){
            if(l.next==null){
                l.next=l2;
                break;
            }
        }
        while(true){
            for (ListNode l=l3;l.next!=null;l=l.next){
                if(l.next.val<l.val){
                    int x;
                    x=l.val;
                    l.val=l.next.val;
                    l.next.val=x;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
            flag=false;
        }
        return l3;
    }
}