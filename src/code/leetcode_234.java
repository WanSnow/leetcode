package code;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_234 {
    public static void main(String[] args) {
        Solution_234 s = new Solution_234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(s.isPalindrome(head));
    }
}
class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp!=null){
            stack.push(temp.val);
            temp=temp.next;
        }
        while(!stack.empty()){
            if(stack.pop()!=head.val){
                return false;
            }
            head=head.next;
        }
        return true;
    }

}