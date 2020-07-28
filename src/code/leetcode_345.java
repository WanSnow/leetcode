package code;

import java.util.ArrayList;
import java.util.List;

/**345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_345 {
    public static void main(String[] args) {
        Solution_345 so = new Solution_345();
        String s = "hello";
        s = so.reverseVowels(s);
        System.out.println(s);
    }
}
class Solution_345 {
    public String reverseVowels(String s) {
        List vowels = new ArrayList();
        StringBuilder strBuilder = new StringBuilder(s);
        int length = s.length();
        int head = 0;
        int tail = length-1;
        //int loc = 0;
        char temp;
        //boolean isFirstTime = true;

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        while(head < tail)
        {
            if(vowels.contains(s.charAt(head)) == true && vowels.contains(s.charAt(tail)) == true)
            {
                temp = s.charAt(head);
                strBuilder.setCharAt(head, s.charAt(tail));
                strBuilder.setCharAt(tail, temp);
                head++;
                tail--;
            }
            else if(vowels.contains(s.charAt(head)) == true && vowels.contains(s.charAt(tail)) != true)
            { tail--;}
            else if(vowels.contains(s.charAt(head)) != true && vowels.contains(s.charAt(tail)) == true)
            { head++;}
            else
            {
                head++;
                tail--;
            }
        }

        return strBuilder.toString();
    }
}