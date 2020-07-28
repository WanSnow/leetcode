package code;

/**231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_231 {
    public static void main(String[] args) {
        Solution_231 s = new Solution_231();
        int n = 16;
        System.out.println(s.isPowerOfTwo(n));
    }
}
class Solution_231 {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        while((n&1)!=1){
            n>>=1;
        }
        if(n==1){
            return true;
        }else {
            return false;
        }
    }
}