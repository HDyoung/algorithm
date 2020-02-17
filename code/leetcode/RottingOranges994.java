package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * RottingOranges994
 *
 * @author dongyoung
 * @since 2019-12-21
 */
public class RottingOranges994 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[3][3];
        grid[0][0] = 2;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[2][0] = 0;
        grid[2][1] = 1;
        grid[2][2] = 1;
        Arrays.asList(grid);
        System.out.println(solution.orangesRotting(grid));
    }

    public static class Solution {
        private int rowSize;
        private int colSize;

        public int orangesRotting(int[][] grid) {
            rowSize = grid.length;
            colSize = grid[0].length;

            Queue<Position> queue = new ArrayDeque<>();
            boolean isExistFresh = false;

            //init first rotting orange
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (grid[i][j] == 2) {
                        queue.add(new Position(i, j));

                    }
                    if (grid[i][j] == 1) {
                        isExistFresh = true;
                    }
                }
            }
            if (!isExistFresh) {
                return 0;
            }

            int result = 0;
            while (queue.size() != 0) {
                List<Position> positions = new ArrayList<>();
                while (queue.size() != 0) {
                    positions.add(queue.poll());
                }
                boolean isExist = false;
                for (Position position : positions) {
                    for (Position pos : position.allDir()) {
                        if (pos.valid()) {
                            if (grid[pos.row][pos.col] == 1) {
                                grid[pos.row][pos.col] = 0;
                                queue.add(pos);
                                isExist = true;
                            }
                        }
                    }
                }
                if(isExist)
                    result++;
            }

            //check exist fresh
            for (int i = 0; i < rowSize; i++) {
                for (int j = 0; j < colSize; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return result;
        }

        class Position {
            int row;
            int col;

            public Position(int x, int y) {
                row = x;
                col = y;
            }

            public List<Position> allDir() {
                return Arrays.asList(right(), left(), up(), down());
            }

            public boolean valid() {
                return row < rowSize && row >= 0 && col >= 0 && col < colSize;
            }

            public Position right() {
                return new Position(row + 1, col);
            }

            public Position left() {
                return new Position(row - 1, col);
            }

            public Position up() {
                return new Position(row, col + 1);
            }

            public Position down() {
                return new Position(row, col - 1);
            }
        }
    }
}
