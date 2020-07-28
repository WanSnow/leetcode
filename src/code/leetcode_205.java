package code;

/**205. 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_205 {
    public static void main(String[] args) {
        Solution_205 so = new Solution_205();
        String s = "abcdefghijk";
        String t = "bcdefghijka";
        System.out.println(so.isIsomorphic(s,t));
    }
}
class Solution_205 {
    public boolean isIsomorphic(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int i1 = toNum(c1);
        int i2 = toNum(c2);
        if(i1==i2){
            return true;
        }else {
            return false;
        }
    }
    public int toNum(char[] c){//替换格式成数字
        if(c.length==0){
            return 0;
        }

        int[] nums = new int[c.length];
        nums[0]=1;
        int flag = 2;
        int count = 0;
        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){//向前寻找是否有相同的
                if(c[i]==c[j]){
                    nums[i]=nums[j];//相同则替换成同一个数
                    break;
                }else {
                    flag++;
                    nums[i]=flag;//否则替换成新数
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            count=count*10+nums[i];
        }
        return count;
    }
}