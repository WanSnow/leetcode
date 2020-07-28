package code;

import java.util.ArrayList;

/**20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_20 {
    public static void main(String[] args) {
        Solution_20 s = new Solution_20();
        String st ="(()(";

        System.out.println(s.isValid(st));
    }
}
class Solution_20 {
    boolean flag = false;
    boolean flag2 = false;
    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        if(c.length%2==1){//不是偶数不对
            return false;
        }
        if(c.length==0){
            return true;
        }
        ArrayList v = new ArrayList();
        v.add(' ');//初始化
        for(int i=0,j=0;i<c.length;i++){
                switch (c[i]){
                    case ')':if((char)v.get(j)!='('){
                        flag=false;
                        flag2=true;
                    }else{
                        v.remove(j);
                        flag=true;
                        j--;
                    }break;
                    case ']':if((char)v.get(j)!='['){
                        flag=false;
                        flag2=true;
                    }else{
                        v.remove(j);
                        flag=true;
                        j--;
                    }break;
                    case '}':if((char)v.get(j)!='{'){
                        flag=false;
                        flag2=true;
                    }else{
                        v.remove(j);
                        flag=true;
                        j--;
                    }break;
                    default:v.add(c[i]);
                            j++;
                }
            if(flag2){
                break;
            }
            if((char)v.get(j)!=' '){//确保全部配对完成
                flag=false;
            }
        }
        return flag;
    }

}