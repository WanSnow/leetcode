package normal;

/**114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_114 {
    public static void main(String[] args) {
        Solution_114 s = new Solution_114();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5,null,new TreeNode(6)));
        s.flatten(root);
        System.out.println("");
    }
}
class Solution_114 {
    public void flatten(TreeNode root) {
        if(root==null||root.right==null&&root.left==null){
            return;
        }
        if(root.right!=null) {
            if (root.right.left != null) {
                flatten(root.right);
            }
            if(root.right.right!=null){
                flatten(root.right.right);
            }
        }
        if(root.left!=null) {
            if (root.left.left != null) {
                flatten(root.left);
            }
            if(root.left.right!=null){
                flatten(root.left.right);
            }
            findRightLeap(root.left).right=root.right;
            root.right = root.left;
        }
        root.left=null;

    }
    public TreeNode findRightLeap(TreeNode root){
        TreeNode temp = root;
        if(temp.right!=null){
            temp=findRightLeap(temp.right);
        }
        return temp;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
