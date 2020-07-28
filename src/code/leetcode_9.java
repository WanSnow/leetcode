package code;

/**9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 */
public class leetcode_9 {

    public static void main(String[] args) {
        int x = 10;
        Solution_9 s = new Solution_9();
        System.out.println(s.isPalindrome(x));
    }
}
class Solution_9 {
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
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            Solution_9 s = new Solution_9();
            if(x==s.reverse(x)){
                return true;
            }else{
                return false;
            }
        }
    }
}