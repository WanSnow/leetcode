package code;

import java.util.ArrayList;
import java.util.List;

/**119. 杨辉三角 II
 *给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_119 {
    public static void main(String[] args) {
        int rowIndex = 3;
        Solution_119 s = new Solution_119();

        for(int i:s.getRow(rowIndex)){
            System.out.print(i+" ");
        }

    }
}
//class Solution_119 {//仿照118
//    public List<Integer> getRow(int rowIndex) {
//        rowIndex++;
//        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
//
//        //如果为空直接返回空链表
//        if (rowIndex == 0) {
//            return null;
//        }
//
//        //初始化第一层为1
//        triangle.add(new ArrayList<>());
//        triangle.get(0).add(1);
//
//        for (int rowNum = 1; rowNum < rowIndex; rowNum++) {
//            List<Integer> row = new ArrayList<>();//这一层
//            List<Integer> prevRow = triangle.get(rowNum-1);//上一层
//
//            //每一层起始为一
//            row.add(1);
//
//            for (int j = 1; j < rowNum; j++) {
//                row.add(prevRow.get(j-1) + prevRow.get(j));
//            }
//
//            //结尾为一
//            row.add(1);
//
//            triangle.add(row);
//        }
//
//        return triangle.get(rowIndex-1);
//    }
//}
class Solution_119 {//进阶空间复杂度为O(k)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex);
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {

            Integer pre = result.get(0);
            for (int j = 1; j < i; j++) {
                Integer tmp = pre;
                pre = result.get(j);
                result.set(j, tmp + pre);
            }
            result.add(1);
        }

        return result;
    }
}