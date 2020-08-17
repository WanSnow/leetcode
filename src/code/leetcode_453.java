package code;

import java.util.Arrays;

/**453. 最小移动次数使数组元素相等
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 *
 *  
 *
 * 示例:
 *
 * 输入:
 * [1,2,3]
 *
 * 输出:
 * 3
 *
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_453 {
    public static void main(String[] args) {
        Solution_453 s = new Solution_453();
        int[] nums = {1,2,3};
        System.out.println(s.minMoves(nums));
    }
}

/**
 * 效率低下
 */
//class Solution_453 {
//    public int minMoves(int[] nums) {
//        int max = nums[0];
//        int position = 0;
//        int turn=0;
//        while(!allEquals(nums, max)) {
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] > max&&i!=position) {
//                    max = nums[i];
//                    nums[position]++;
//                    position=i;
//                    if(allEquals(nums,max)){
//                        return turn+1;
//                    }
//                } else if(i!=position){
//                    nums[i]++;
//                }
//            }
//            turn++;
//        }
//        return turn;
//    }
//    public boolean allEquals(int[] nums, int max){
//        for(int i=0;i<nums.length;i++){
//            if(nums[i]!=max){
//                return false;
//            }
//        }
//        return true;
//    }
//}

/**
 * 排序法
  */
//class Solution_453 {
//    public int minMoves(int[] nums) {
//        Arrays.sort(nums);
//        int count = 0;
//        for (int i = nums.length - 1; i > 0; i--) {
//            count += nums[i] - nums[0];
//        }
//        return count;
//    }
//}

/**
 * 动态规划
 */
class Solution_453 {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = (moves + nums[i]) - nums[i - 1];
            nums[i] += moves;
            moves += diff;
        }
        return moves;
    }
}