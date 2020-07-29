package diffcult;

import java.util.ArrayList;

/**
 * 我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
 *
 * 迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
 *
 * 要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
 *
 * 迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
 *
 * 我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
 *
 * 示例 1：
 *
 * 输入： ["S#O", "M..", "M.T"]
 *
 * 输出：16
 *
 * 解释：最优路线为： S->O, cost = 4, 去搬石头 O->第二行的M, cost = 3, M机关触发 第二行的M->O, cost = 3, 我们需要继续回去 O 搬石头。 O->第三行的M, cost = 4, 此时所有机关均触发 第三行的M->T, cost = 2，去T点拿宝藏。 总步数为16。
 *
 * 示例 2：
 *
 * 输入： ["S#O", "M.#", "M.T"]
 *
 * 输出：-1
 *
 * 解释：我们无法搬到石头触发机关
 *
 * 示例 3：
 *
 * 输入： ["S#O", "M.T", "M.."]
 *
 * 输出：17
 *
 * 解释：注意终点也是可以通行的。
 *
 * 限制：
 *
 * 1 <= maze.length <= 100
 * 1 <= maze[i].length <= 100
 * maze[i].length == maze[j].length
 * S 和 T 有且只有一个
 * 0 <= M的数量 <= 16
 * 0 <= O的数量 <= 40，题目保证当迷宫中存在 M 时，一定存在至少一个 O 。
 */

public class leetcode_LCP13 {
    public static void main(String[] args) {
        Solution_LCP13 s = new Solution_LCP13();
        s.minimalSteps(new String[]{"S#O", "M..", "M.T"});
    }
}
class Solution_LCP13 {
    BlockArea[][] map = new BlockArea[100][100];
    public int minimalSteps(String[] maze) {
        ArrayList<BlockArea>[] specialBlocks = BlockArea.stringMazeToBlockAreaMap(map, maze);
        for(BlockArea blockArea:specialBlocks[0]){
            if(blockArea.up.type=='#'&&blockArea.left.type=='#'&&blockArea.right.type=='#'&&blockArea.down.type=='#'){
                return -1;
            }
        }
        for(BlockArea blockArea:specialBlocks[1]){
            if(blockArea.up.type=='#'&&blockArea.left.type=='#'&&blockArea.right.type=='#'&&blockArea.down.type=='#'){
                return -1;
            }
        }
        for(BlockArea blockArea:specialBlocks[2]){
            if(blockArea.up.type!='#'||blockArea.left.type!='#'||blockArea.right.type!='#'||blockArea.down.type!='#'){
                break;
            }
        }
        for(BlockArea blockArea:specialBlocks[3]){
            if(blockArea.up.type!='#'||blockArea.left.type!='#'||blockArea.right.type!='#'||blockArea.down.type!='#'){
                break;
            }
        }
        int count = 0;
        return count;
    }

    /**
     * 走迷宫
     * @return 花费的布数
     */
    public int walk(){
        return -1;
    }
}

/**
 * 地图块类
 */
class BlockArea{
    public char type;
    public BlockArea up;
    public BlockArea left;
    public BlockArea right;
    public BlockArea down;

    public BlockArea(char type){
        this.type=type;
    }

    /**
     * 字符串迷宫转块地图
     * @param map
     * @param maze
     */
    public static ArrayList[] stringMazeToBlockAreaMap(BlockArea[][] map, String[] maze){
        //0是start块，1是Target块，2是岩石块,3是机关块
        ArrayList<BlockArea>[] specialBlocks = new ArrayList[4];
        for(ArrayList<BlockArea> list:specialBlocks){
            list = new ArrayList<>();
        }
        for(int i=0;i<maze.length;i++){
            String temp=maze[i];
            for(int j=0;j<temp.length();j++){
                switch (temp.charAt(j)){
                    case 'S':
                        map[i][j] = new BlockArea('S');
                        specialBlocks[0].add(map[i][j]);
                        break;
                    case 'T':
                        map[i][j] = new BlockArea('T');
                        specialBlocks[1].add(map[i][j]);
                        break;
                    case 'O':
                        map[i][j] = new BlockArea('O');
                        specialBlocks[2].add(map[i][j]);
                        break;
                    case '.':
                        map[i][j] = new BlockArea('.');
                        break;
                    case 'M':
                        map[i][j] = new BlockArea('M');
                        specialBlocks[3].add(map[i][j]);
                        break;
                    default:
                        map[i][j] = new BlockArea('#');
                        break;
                }
            }
        }
        connectNearBlockArea(map);
        return specialBlocks;
    }

    /**
     * 链接相邻地图块
     * @param map
     */
    public static void connectNearBlockArea(BlockArea[][] map){
        for(int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                if(map[i][j]==null){
                    continue;
                }
                try{
                    if(map[i-1][j]!=null){
                        map[i][j].up = new BlockArea(map[i-1][j].type);
                        map[i-1][j].down = new BlockArea(map[i][j].type);
                    }
                }catch (IndexOutOfBoundsException e){
                    map[i][j].up = new BlockArea('#');
                }
                try{
                    if(map[i][j-1]!=null){
                        map[i][j].left = new BlockArea(map[i][j-1].type);
                        map[i][j-1].right = new BlockArea(map[i][j].type);
                    }
                }catch (IndexOutOfBoundsException e){
                    map[i][j].left = new BlockArea('#');
                }
                try{
                    if(map[i+1][j]!=null){
                        map[i][j].down = new BlockArea(map[i+1][j].type);
                        map[i+1][j].up = new BlockArea(map[i][j].type);
                    }
                }catch (IndexOutOfBoundsException e){
                    map[i][j].down = new BlockArea('#');
                }
                try{
                    if(map[i][j+1]!=null){
                        map[i][j].right = new BlockArea(map[i][j+1].type);
                        map[i][j+1].left = new BlockArea(map[i][j].type);
                    }
                }catch (IndexOutOfBoundsException e){
                    map[i][j].right = new BlockArea('#');
                }
            }
        }
    }

    public static void checkMap(BlockArea[][] map){

    }
}