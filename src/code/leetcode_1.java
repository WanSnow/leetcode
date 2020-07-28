/**1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package code;


public class leetcode_1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution_1 s = new Solution_1();
        int[] aws = s.twoSum(nums,target);
        for(int i:aws){
            System.out.println(i);
        }
    }


}
class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        boolean flag = false;
        int[] ans = new int[2];
        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<nums.length;j++){
                if (j==i){
                    continue;
                }
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    flag=true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        if(!flag){
            System.out.println("没有");
        }
        return ans;
    }
}