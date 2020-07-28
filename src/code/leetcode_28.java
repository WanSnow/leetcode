package code;

/**28. 实现 strStr()
 * 实现 strStr() 函数。

 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

 示例 1:

 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:

 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

 */
public class leetcode_28 {
    public static void main(String[] args) {
        String haystack="hello";
        String needle="ll";
        Solution_28 s = new Solution_28();
        System.out.println(s.strStr(haystack,needle));

    }
}
class Solution_28 {
    public int strStr(String haystack, String needle) {
        if(needle==null){
            return 0;
        }
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();
        int p=0;

        for(int i=0,j=0;j<s2.length;) {
            if(i>=s1.length){
                return -1;
            }
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i=i-j+1;
                j = 0;
            }
            p=i-s2.length;
        }
        return p;
    }
}