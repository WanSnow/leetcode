package code;
/**104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_104 {
    public static void main(String[] args) {
        Solution_104 s = new Solution_104();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.maxDepth(root));
    }
}
//class Solution_104 {//效率略低
//    public int maxDepth(TreeNode root) {
//        return depthCount(root,0);
//    }
//    public int depthCount(TreeNode root,int count){
//        if(root == null){
//            return count;
//        }
//        count++;
//        if(depthCount(root.left,count)>depthCount(root.right,count)){
//            return depthCount(root.left,count);
//        }else {
//            return depthCount(root.right,count);
//        }
//    }
//}
class Solution_104 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

}