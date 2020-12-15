package cn.leetcode.array;

/**
 * @author 悠一木碧
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 */

public class TicTacToe {
    /**
     * 查看每一行的字符串是否都为O或者X字符, 是, 说明有胜者, 并返回这和个字符
     * 到达最后一行的时候, 再查看对角线和竖列的字符串是否为纯字符
     * @param board 棋盘数组
     * @return 返回胜利者的字符串
     */
    public String tictactoe(String[] board) {
        int row, col;
        row = col = board.length;
        boolean hasWinner = false;
        boolean hasEmpty = false;

        StringBuilder xBuilder = new StringBuilder();
        StringBuilder oBuilder = new StringBuilder();
        for(int i = 0; i < row; i++){
            xBuilder.append('X');
            oBuilder.append('O');
        }
//        x的胜利标志字符串, o的胜利标志字符串
        String x = xBuilder.toString();
        String o = oBuilder.toString();

        for (int r = 0; r < row; r++) {
//            查看有无空格
            if(!hasEmpty && board[r].contains(" ")){
                hasEmpty = true;
            }
            if(board[r].contains(x)){
                return "X";
            } else if(board[r].contains(o)){
                return "O";
            }


            if(r == row - 1){
//                到达最后一行, 开始寻找对角线的字符串
                StringBuilder builder1 = new StringBuilder();
                for(int n = 0; n < row; n++){
                    builder1.append(board[n].charAt(row - n - 1));
                }
                if(builder1.toString().contains(x)){
                    return "X";
                }
                else if(builder1.toString().contains(o)){
                    return "O";
                }
//                从第一列开始, 取出每一列的字符组成一个字符串
                for(int c = 0; c < col; c++){
                    StringBuilder builder = new StringBuilder();
                    for (int k = 0; k < row; k++) {
                        builder.append(board[k].charAt(c));
                    }
                    if(builder.toString().contains(x)){
                        return "X";
                    }
                    else if(builder.toString().contains(o)){
                        return "O";
                    }
                }

                StringBuilder builder2 = new StringBuilder();
                for(int n = 0; n < row; n++){
                    builder1.append(board[n].charAt(n));
                }
                if(builder1.toString().contains(x)){
                    return "X";
                }
                else if(builder1.toString().contains(o)){
                    return "O";
                }
            }




        }
        if(hasEmpty){
            return "Pending";
        } else{
            return "Draw";
        }

    }


}
