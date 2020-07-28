package code;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_14 {
    public static void main(String[] args) {
        Solution_14 s = new Solution_14();
        String[] strs ={"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length<1){//过滤空字符串数组
            return "";
        }
        String lcp="";
        ArrayList temp = new ArrayList();
        char flag='\0';
        for(String o:strs){
            if(o.toCharArray().length==0){//过滤空字符串
                return "";
            }
            temp.add(o.toCharArray());
        }
        int j=0;
        while (true) {
            char[] l=null;
            int leng=1000;
            for (int i = 0; i < temp.size(); i++) {

                l=(char[])temp.get(i);
                if(leng>l.length){//确定最短字符串长
                    leng=l.length;
                }
                if(i==0){
                    flag=l[j];
                    continue;
                }
                if(flag!=l[j]){
                    return lcp;
                }
            }
            lcp=lcp+flag;
            j++;
            if(j>leng-1){
                return lcp;
            }
        }
    }

}