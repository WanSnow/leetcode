package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_290 {
    public static void main(String[] args) {
        Solution_290 s = new Solution_290();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(s.wordPattern(pattern,str));;
    }
}
class Solution_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if (pattern.length() != arr.length){
            return false;
        }
        int len = pattern.length();
        for (int i = 0; i < len; i++) {
            if(pattern.indexOf(pattern.charAt(i)) != indexOf(arr, arr[i])){
                return false;
            }
        }
        return true;
    }

    /**寻找某一字符串在数组中的位置
     *
     * @param arrays 字符串数组
     * @param searchString 要寻找的值
     * @return
     */
    public static int indexOf(String[] arrays, String searchString) {
        int ans = -1;
        for(int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(searchString)) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}