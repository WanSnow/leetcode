/**7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
package code;

public class leetcode_7 {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(x);
        Solution_7 s = new Solution_7();
        x = s.reverse(x);
        System.out.println(x);
    }

}
class Solution_7 {
    public int reverse(int x) {
        int temp = 0;
        double flag=0;
        double y = Math.pow(2,31);
        for(int i;x!=0;){
            flag = flag*10.0+x%10;
            temp = temp*10+x%10;
            if(flag>y-1||flag<-y)return 0;
            x/=10;
        }

        return temp;
    }
}