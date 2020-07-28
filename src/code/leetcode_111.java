package code;

/**111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_111 {
    public static void main(String[] args) {
        Solution_111 s = new Solution_111();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right = new TreeNode(7);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
        System.out.println(s.minDepth(root));
    }
}
class Solution_111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        if(root.left==null||root.right==null){
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.max(left,right)+1;
        }
        return minDeep(root);
    }
    public int minDeep(TreeNode root){
        if(root==null){
            return 0;
        }else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.min(left,right)+1;
        }
    }
}