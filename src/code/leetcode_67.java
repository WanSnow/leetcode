package code;

/**67. 二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode_67 {
    public static void main(String[] args) {
        Solution_67 s = new Solution_67();
        String a="101",b="1";
        System.out.println(s.addBinary(a,b));

    }
}
class Solution_67 {
    public String addBinary(String a, String b) {
        int lon;
        char x,y,z;
        if(a.length()>b.length()){
            lon=a.length();
        }else{
            lon=b.length();
        }
        char[] c = new char[lon+1];
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        for(int i=ca.length-1,j=cb.length-1,k=lon;i>-1||j>-1;i--,j--,k--){
            if(i>=0){
                x=ca[i];
            }else {
                x=0;
            }
            if(j>=0){
                y=cb[j];
            }else {
                y=0;
            }
            z=c[k];
            switch (toflag(x,y,z)){
                case 0:c[k]='0';break;
                case 1:c[k]='1';break;
                case 2:c[k]='0';c[k-1]='1';break;
                case 3:c[k]='1';c[k-1]='1';break;
                default:break;
            }
        }
        String s="";
        for(char o:c){
            if(o!='\0') {
                s = s + o;
            }
        }

        return s;
    }
    public int toflag(char a,char b,char c){
        int i=0;
        if(a=='1'){
            i++;
        }
        if(b=='1'){
            i++;
        }
        if(c=='1'){
            i++;
        }
        return i;
    }
}