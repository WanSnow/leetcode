package code;

/**206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_206 {
    public static void main(String[] args) {
        Solution_206 s = new Solution_206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode another = s.reverseList(head);
        while(another!=null){
            System.out.println(another.val);
            another=another.next;
        }
    }
}

/**
 * 递归
 */
//class Solution_206 {
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode p = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
//    }
//}

/**
 * 迭代
 */
class Solution_206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}