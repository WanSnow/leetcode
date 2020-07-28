package code;

/**53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_53 {
    public static void main(String[] args) {
        int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
        Solution_53 s = new Solution_53();
        System.out.println(s.maxSubArray(nums));
    }
}

class Solution_53 {
    public int maxSubArray(int[] nums) {
//        int aws=nums[0];//原来想的
//        int flag=0;
//        for(int i=0;i<nums.length;i++){
//            for (int j=i;j<nums.length;j++) {
//                flag += nums[j];
//                if (flag > aws) {
//                    aws = flag;
//                }
//            }
//            flag=0;
//        }
//        return aws;
        /**
         * 修改后的方法
         */
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {//确定sum是否为增益效果
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}