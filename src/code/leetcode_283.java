package code;

/**283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_283 {
    public static void main(String[] args) {
        Solution_283 s = new Solution_283();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
class Solution_283 {
    public void moveZeroes(int[] nums) {
        int curr=0;//当前位置
        int tar=0;//要移动的位置
        int count=0;//有几个非0数
        for(;curr<nums.length;curr++){//将所有非0数提前
            if(nums[curr]!=0){
                nums[tar]=nums[curr];
                tar++;
                count++;
            }
        }
        for(;count<nums.length;count++){//将剩余位置的数全部设置成0
            nums[count]=0;
        }
    }
}