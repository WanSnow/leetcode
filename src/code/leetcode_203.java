package code;

/**203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class leetcode_203 {
    public static void main(String[] args) {
        Solution_203 s = new Solution_203();
        int val = 6;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head =s.removeElements(head,val);
        for (ListNode i=head;i!=null;i=i.next){
            System.out.println(i.val);
        }
    }
}
class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;//将第一个结点纳入检测范围

        ListNode prev = sentinel;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;//删除该结点
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void printListNode(ListNode head){
        if(head!=null){
            System.out.print(head.val);
            printListNode(head.next);
        }
    }
 }