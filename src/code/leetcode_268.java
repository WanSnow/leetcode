package code;

import java.util.ArrayList;

/**268. 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_268 {
    public static void main(String[] args) {
        Solution_268 s = new Solution_268();
        int[] nums = {3,0,1};
        System.out.println(s.missingNumber(nums));
    }
}

/**
 * 效率低
 */
//class Solution_268 {
//    public int missingNumber(int[] nums) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0;i<=nums.length;i++){
//            list.add(i);
//        }
//        for(int i=0;i<nums.length;i++){
//            list.remove((Object)nums[i]);
//        }
//        return list.get(0);
//    }
//}

/**
 * 数学求和
 */
//class Solution_268 {
//    public int missingNumber(int[] nums) {
//        int expectedSum = nums.length*(nums.length + 1)/2;
//        int actualSum = 0;
//        for (int num : nums) actualSum += num;
//        return expectedSum - actualSum;
//    }
//}

/**
 * 位运算
 */
class Solution_268 {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
