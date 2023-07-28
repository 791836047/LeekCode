package com.whl.leekcode.mid;

/**
 * 单词搜索
 * @author liaowenhui
 * @date 2023/4/18 9:48
 */
public class HOT79 {
    /**
     * 左，上，下，右
     */
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    /**
     * 学习怎么求一个二维数组的行和列
     * 时间复杂度见
     * https://leetcode.cn/problems/word-search/solutions/411613/dan-ci-sou-suo-by-leetcode-solution/?orderBy=most_votes
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        //3行，注意.length不是.length()
        rows = board.length;
        //!!注意只需要判断行为0
        if (rows == 0) {
            return false;
        }
        //4列
        cols = board[0].length;
        //3行4列, 为了防止重复遍历相同的位置，需要额外维护一个与 board等大的 visited数组，用于标识每个位置是否被访问过。每次遍历相邻位置时，需要跳过已经被访问的位置。
        visited = new boolean[rows][cols];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        //从左至右，从上到下去找符合word的字符
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * DFS即Depth First Search.
     * @param x
     * @param y
     * @param begin
     * @return
     */
    private boolean dfs(int x, int y, int begin) {
        //注意理解结束条件，长度相等，最后一个字符相等则返回true
        if (begin == len - 1) {
            return board[x][y] == charArray[begin];
        }
        if (board[x][y] == charArray[begin]) {
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            //!!注意理解，从别的字符重新开始的话需要置为false
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    /*public boolean existTest(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int length1 = word.length();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

            }
        }


    }*/

        public static void main(String[] args) {

            HOT79 solution = new HOT79();
        //注意怎么初始化二维数组的
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        boolean exist1 = solution.exist(board, word1);
        boolean exist2 = solution.exist(board, word2);
        boolean exist3 = solution.exist(board, word3);
        System.out.println(word1 + "单词搜索结果为：" +exist1);
        System.out.println(word2 + "单词搜索结果为：" + exist2);
        System.out.println(word3 + "单词搜索结果为：" +exist3);
    }

}
