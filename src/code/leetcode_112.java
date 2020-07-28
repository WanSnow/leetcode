package code;

/**112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_112 {
    public static void main(String[] args) {
        Solution_112 s = new Solution_112();
        int sum = 22;
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
//        int sum = 0;
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(-2);
//        root.right = new TreeNode(-3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.left = new TreeNode(-2);
//        root.left.left.left = new TreeNode(-1);
        System.out.println(s.hasPathSum(root,sum));
    }
}
class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        int count = root.val;
        if(root.left==null&&root.right==null){
            return count==sum;
        }
        if(root.left==null||root.right==null) {
            if (root.left == null) {
                return hasPathSum(root.right,sum-count);
            }else {
                return hasPathSum(root.left,sum-count);
            }
        }
        count=0;
        return countPath(root,count,sum);
    }
    public boolean countPath(TreeNode root,int count,int sum){
        if(root==null){
            return count==sum;
        }
        count+=root.val;
        if(root.left==null){
            return countPath(root.right,count,sum);
        }else if(root.right==null){
            return countPath(root.left,count,sum);
        }
        return countPath(root.right,count,sum)||countPath(root.left,count,sum);
    }
}