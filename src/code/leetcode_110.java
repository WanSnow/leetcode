package code;

/**110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_110 {
    public static void main(String[] args) {
        Solution_110 s = new Solution_110();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.isBalanced(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println(s.isBalanced(root2));
    }
}
class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int i = depth(root.right)-depth(root.left);
        if(i>=-1&&i<=1){
            return isBalanced(root.right)&&isBalanced(root.left);
        }else {
            return false;
        }
    }
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }else {
            int left = depth(root.left);
            int right = depth(root.right);
            return Math.max(left,right)+1;
        }
    }
}