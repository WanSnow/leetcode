package code;

import java.util.ArrayList;

/**83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_83 {
    public static void main(String[] args) {
        Solution_83 s = new Solution_83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode l =head;
        while(l!=null){
            System.out.print(l.val);
            l=l.next;
        }
        head=s.deleteDuplicates(head);
        l=head;
        System.out.println();
        while(l!=null){
            System.out.print(l.val);
            l=l.next;
        }
    }
}
//class Solution_83 {
//    public ListNode deleteDuplicates(ListNode head) {//效率低，空间占用高
//        if(head==null){
//            return null;
//        }
//        ListNode aws = new ListNode(head.val);
//        ListNode temp=aws;
//        while (true){
//            if(!listShow(aws,head.val)){
//                temp.next = new ListNode(head.val);
//                temp=temp.next;
//            }
//            if(head.next==null){
//                return aws;
//            }
//            head=head.next;
//
//        }
//    }
//    public boolean listShow(ListNode l,int i){
//        if(l==null){
//            return false;
//        }
//        if(l.val==i){
//            return true;
//        }
//        if(l.next!=null){
//            return listShow(l.next,i);
//        }
//        return false;
//    }
//}
class Solution_83{
    public ListNode deleteDuplicates(ListNode head){
        ListNode temp = head;
        while (temp!=null&&temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return head;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }