package code;

/**342. 4的幂
 *
 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。

 示例 1:

 输入: 16
 输出: true
 示例 2:

 输入: 5
 输出: false
 进阶：
 你能不使用循环或者递归来完成本题吗？
 */
public class leetcode_342 {
    public static void main(String[] args) {
        Solution_342 s = new Solution_342();
        int num = 16;
        System.out.println(s.isPowerOfFour(num));
    }
}
class Solution_342 {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        while (num % 4 == 0){
            num /= 4;
        }
        return num == 1;
    }
}