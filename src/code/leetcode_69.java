package code;

/**69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_69 {
    public static void main(String[] args) {
        Solution_69 s = new Solution_69();
        int i=8;
        System.out.println(s.mySqrt(i));
    }
}
//class Solution_69 {//效率极低
//    public int mySqrt(int x) {
//        for(double i=0;;i++){
//            if(i*i>x){
//                return (int)i-1;
//            }
//        }
//    }
//}
//class Solution_69 {
//    public int mySqrt(int x) {//偷工减料型
//        return (int)Math.sqrt(x);
//
//    }
//}
class Solution_69 {
    public int mySqrt(int x) {//二分法
        long high=x;
        long low=0;
        long temp;
        while(true){
            temp=(high+low)/2;
            if(temp*temp>x){
                high=temp;
            }else if(temp*temp<x){
                low=temp+1;
                if(low*low>x){
                    return (int)temp;
                }
            }else{
                return (int)temp;
            }
        }
    }
}