package code;

import java.util.ArrayList;
import java.util.List;

/**118. 杨辉三角
 在杨辉三角中，每个数是它左上方和右上方的数的和。
 输入: 5
 输出:
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/pascals-triangle
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_118 {
    public static void main(String[] args) {
        int numRows = 5;
        Solution_118 s = new Solution_118();
        for (List<Integer> l:s.generate(numRows)){
            for(int i:l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

        //如果为空直接返回空链表
        if (numRows == 0) {
            return triangle;
        }

        //初始化第一层为1
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();//这一层
            List<Integer> prevRow = triangle.get(rowNum-1);//上一层

            //每一层起始为一
            row.add(1);

            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            //结尾为一
            row.add(1);

            triangle.add(row);
        }

        return triangle;

    }
}