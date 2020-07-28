package code;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_172 {
    public static void main(String[] args) {
        Solution_172 s = new Solution_172();
        int n = 30;
        System.out.println(s.trailingZeroes(n));
    }
}

/**
 * 有上限
 */
//class Solution_172 {
//    public int trailingZeroes(int n) {
//        int count=0;
//        long num=n;
//        for(int i = n-1;i>0;i--){
//            num=num*i;
//        }
//        while(num%10==0&&num/10!=0){
//            count++;
//            num/=10;
//        }
//        return count;
//    }
//}

/**
 * 效率低
 */
//class Solution_172 {
//    public int trailingZeroes(int n) {
//        int count = 0;
//        for (int i = 1; i <= n; i++) {
//            int N = i;
//            while (N > 0) {
//                if (N % 5 == 0) {
//                    count++;
//                    N /= 5;
//                } else {
//                    break;
//                }
//            }
//        }
//        return count;
//    }
//}
class Solution_172 {
    public int trailingZeroes(int n){
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}