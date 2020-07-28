package code;

import java.util.HashSet;
import java.util.Set;

/**219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_219 {
    public static void main(String[] args) {
        Solution_219 s = new Solution_219();
        int[] nums = {1,2,3,1};
        int k = 3;
        System.out.println(s.containsNearbyDuplicate(nums,k));
    }
}

/**
 * 暴力法
 * 效率低
 */
//class Solution_219 {
//    public boolean containsNearbyDuplicate(int[] nums, int k) {
//        for(int i=0;i<nums.length;i++){
//            for(int j=1;j<=k&&i+j<nums.length;j++) {
//                if (nums[i] == nums[i + j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//}
class Solution_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}