package code;

/**258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_258 {
    public static void main(String[] args) {
        Solution_258 s = new Solution_258();
        int num=38;
        System.out.println(s.addDigits(num));
    }
}

/**
 * 效率低
 */
//class Solution_258 {
//    public int addDigits(int num) {
//        int count=0;
//        do{
//            count=0;
//            while(num!=0){
//                count+=num%10;
//                num/=10;
//            }
//            num=count;
//
//        }while(count>=10);
//        return count;
//    }
//}

/**
 * 网上给的解
 */
class Solution_258 {
    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}