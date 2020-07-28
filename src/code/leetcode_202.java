package code;

import java.util.HashSet;
import java.util.Set;

/**202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例: 
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_202 {
    public static void main(String[] args) {
        Solution_202 s = new Solution_202();
        int n=19;
        System.out.println(s.isHappy(n));
    }
}
class Solution_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while(n != 1){//等于1时为快乐数跳出循环
            n = change(n);
            if(set.contains(n)) return false;//如果发现循化说明不是快乐数
            set.add(n);
        }
        return true;
    }

    public int change(int n){//调整至下一个数
        int sum = 0;
        int num;
        while(n != 0){
            num = n%10;
            n /= 10;
            sum += num*num;
        }
        return sum;
    }
}