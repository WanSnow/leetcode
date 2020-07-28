package code;

/**160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_160 {
    public static void main(String[] args) {
        Solution_160 s = new Solution_160();

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);

        ListNode point = new ListNode(8);
        point.next = new ListNode(4);
        point.next.next = new ListNode(5);

        headA.next.next = point;
        headB.next.next.next = point;

        System.out.println(s.getIntersectionNode(headA,headB).val);
    }
}

/**
 * 暴力遍历，效率极低
 */
//class Solution_160 {
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode a=headA;
//        ListNode b=headB;
//        while(a!=null){
//            b=headB;
//            while(b!=null){
//                if (a==b){
//                    return b;
//                }
//                b=b.next;
//            }
//            a=a.next;
//        }
//        return null;
//    }
//}

/**
 * 双指针法
 */
class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}