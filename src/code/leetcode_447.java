package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**447. 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 *
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 *
 * 示例:
 *
 * 输入:
 * [[0,0],[1,0],[2,0]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_447 {
    public static void main(String[] args) {
        Solution_447 s = new Solution_447();

    }
}
class Solution_447 {
    public int numberOfBoomerangs(int[][] points) {
        int result=0;
        for(int i=0;i<points.length;i++){
            //存储点i到所有其他点的距离出现的频次（Key为距离，Value为频次）
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i!=j){
                    int dis = dis(points[i], points[j]);
                    if(((HashMap) map).containsKey(dis))
                        map.put(dis,map.get(dis)+1);
                    else
                        map.put(dis,1);
                }
            }
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if(entry.getValue()>1)
                    //如果存在距离相等的两点的数量大于一，则可以组队（回旋镖）
                    //如果存在2个则2种排列方法，存在3个则6种排列方法，存在n个则n（n-1）中排列方法
                    result=result+entry.getValue()*(entry.getValue()-1);
            }
        }
        return result;
    }
    //计算两元组距离
    public static int dis(int[] left, int[] right){
        return (int) (Math.pow(left[0]-right[0],2)+Math.pow(left[1]-right[1],2));
    }
}