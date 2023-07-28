package com.whl.leekcode.mid;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 腐烂的橘子
 * @author liaowenhui
 * @date 2023/5/15 10:29
 */
public class HOT994 {
    /**
     * 上 左 下 右
     */
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};

    /**
     * 时间复杂度：O(nm) 即进行一次广度优先搜索的时间，其中 n=grid.length, m=grid[0].length 。
     * 空间复杂度：O(nm) 需要额外的 dis 数组记录每个新鲜橘子被腐烂的最短时间，大小为 O(nm)，
     * 且广度优先搜索中队列里存放的状态最多不会超过 nm个，最多需要 O(nm) 的空间，所以最后的空间复杂度为 O(nm)。
     * @param grid
     * @return
     */
    public static int orangesRotting(int[][] grid) {
        //R3行，C3列
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        //将这些腐烂橘子都放进队列里进行广度优先搜索
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    //从左到右，从上往下第几个
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            //根据code反推出原来是r行，c列
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                //按上左下右的顺序
                int nr = r + dr[k];
                int nc = c + dc[k];
                //在范围内，且是新鲜橘子
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    //把已腐烂的新鲜橘子的值由 1 改为 2
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        //最后看网格中是否有值为 1即新鲜的橘子
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                new int[]{2,1,1},
                new int[]{1,1,0},
                new int[]{0,1,1}
        };
        System.out.println("最小分钟数:" + orangesRotting(grid));
    }

}
