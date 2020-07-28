package code;

/**88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_88 {
    public static void main(String[] args) {
        Solution_88 s = new Solution_88();
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        s.merge(nums1,3,nums2,3);
        for (int i:nums1){
            System.out.print(i);
        }
    }
}
class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length==0){
            return;
        }
        int[] nums = new int[m+n];
        for(int i=0,j=0,k=0;k<nums.length;k++){
            if(nums1[i]<nums2[j]&&i<m){
                nums[k]=nums1[i];
                i++;
            }else {
                nums[k]=nums2[j];
                j++;
            }
            if(i>=m){
                for (k++;k<nums.length;k++,j++){
                    nums[k]=nums2[j];
                }
            }
            if(j>=n){
                for (k++;k<nums.length;k++,i++){
                    nums[k]=nums1[i];
                }
            }
        }
        for (int i=0;i<nums1.length;i++){
            nums1[i]=nums[i];
        }
    }
}