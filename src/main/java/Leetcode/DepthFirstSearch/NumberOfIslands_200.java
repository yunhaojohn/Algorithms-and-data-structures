package Leetcode.DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands_200 {

    // BFS - 4ms
//    public int numIslands(char[][] grid) {
//        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//        int res = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == '1') {
//                    res ++;
//                    Queue<int[]> queue = new LinkedList<>();
//                    queue.add(new int[]{i, j});
//                    grid[i][j] = '0';
//                    while (!queue.isEmpty()) {
//                        int[] pos = queue.poll();
//                        for (int[] dir: dirs) {
//                            int row = pos[0] + dir[0], col = pos[1] + dir[1];
//                            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1') {
//                                grid[row][col] = '0';
//                                queue.add(new int[]{row, col});
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }

    // DFS - 1ms
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    // Union found, O(mn)
//    public int numIslands(char[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        int[] roots = new int[m*n];
//        int[][] dirs = {{0, 1}, {1, 0}};
//        int num = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int ind = i*n+j;
//                roots[ind] = ind;
//                if (grid[i][j] == '1') {
//                    num ++;
//                }
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == '1') {
//                    // union neighbor 1s
//                    for (int[] dir: dirs) {
//                        int row = i + dir[0], col = j + dir[1];
//                        if (row < m && col < n && grid[row][col] == '1') {
//                            int r1 = findRoot(roots, i*n+j);
//                            int r2 = findRoot(roots, row*n+col);
//                            if (r1 != r2) {
//                                num --;
//                                roots[r2] = r1;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return num;
//    }
//
//    public int findRoot(int[] roots, int ind) {
//        while (roots[ind] != ind) {
//            roots[ind] = roots[roots[ind]];
//            ind = roots[ind];
//        }
//        return ind;
//    }
}
