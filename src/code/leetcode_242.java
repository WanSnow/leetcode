package code;

/**242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_242 {
    public static void main(String[] args) {
        Solution_242 so = new Solution_242();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(so.isAnagram(s,t));
    }
}

/**
 * 效率极低
 */
//class Solution_242 {
//    public boolean isAnagram(String s, String t) {
//        char[] c1 = s.toCharArray();
//        char[] c2 = t.toCharArray();
//        if(c1.length!=c2.length){
//            return false;
//        }
//        c1=order(c1);
//        c2=order(c2);
//        for(int i=0;i<c1.length;i++){
//            if(c1[i]!=c2[i]){
//                return false;
//            }
//        }
//        return true;
//    }
//    public char[] order(char[] chars){
//        char temp;
//        for(int i=0;i<chars.length;i++){
//            for (int j=i+1;j<chars.length;j++){
//                if(chars[i]>chars[j]){
//                    temp=chars[i];
//                    chars[i]=chars[j];
//                    chars[j]=temp;
//                }
//            }
//        }
//        return chars;
//    }
//}

/**
 * 字母频率计数
 */
class Solution_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];//每个字母计数
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}