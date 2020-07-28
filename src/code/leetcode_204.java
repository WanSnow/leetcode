package code;

import java.util.ArrayList;

/**204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class leetcode_204 {
    public static void main(String[] args) {
        Solution_204 s= new Solution_204();
        int n=499979;
        System.out.println(s.countPrimes(n));
    }
}

/**
 * 暴力法
 */
//class Solution_204 {
//    public int countPrimes(int n) {
//        int count=0;
//        for (int i=2;i<n;i++){
//            if(isPrimes(i)){
//                count++;
//            }
//        }
//        return count;
//    }
//    public boolean isPrimes(int i){
//        int sqrt = (int)Math.sqrt(i);
//        if(i==2){
//            return true;
//        }
//        if(i%2==0){
//            return false;
//        }
//
//        int n=3;
//        while(n<=sqrt){
//            if(i%n==0){
//                return false;
//            }
//            n=n+2;
//        }
//        return true;
//    }
//}

/**
 * 埃式法
 */
class Solution_204 {
    public int countPrimes(int n) {
        if(n<3){
            return 0;
        }
        int count = 0;
        int sqrt = (int)Math.sqrt(n);
        int[] nums = new int[n];
        for(int i=2;i<n;i++){
            nums[i]=i;
        }
        for(int i=2;i<=sqrt;i++){
            if(nums[i]==0){
                continue;
            }
            for(int j=2;i*j<n;j++){
                nums[i*j]=0;
            }
        }
        for(int i=2;i<n;i++){
            if(nums[i]!=0){
                count++;
            }
        }
        return count;
    }
}

/**
 * 网上copy的，效率比自己的快
 */
//class Solution {
//    public int countPrimes(int n) {
//        if (n < 2) return 0;  //2以下无质数
//        int count = 0;    //计数
//        boolean[] nums = new boolean[n];//判断该数是否为质数false为质数
//
//        for (int i = 2; i * i < n; i++){
//            if (!nums[i]) {
//                for (int j = i * i; j < n; j += i) {//剔除所有i的倍数
//                    if (nums[j])
//                        continue;
//                    count++;
//                    nums[j] = true;
//                }
//            }
//        }
//        return n - count - 2;//减去0和1，以及不是质数的数
//    }
//}