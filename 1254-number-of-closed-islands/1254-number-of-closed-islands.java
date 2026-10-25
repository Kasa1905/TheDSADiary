class Solution {
    private static final int LAND = 0;
    private static final int WATER = 1;
    private static final int[][] DELTA = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int closedIsland(int[][] grid) {
        floodAll(grid, this::findBorderIsland);
        return floodAll(grid, this::findIsland);
    }

    private int floodAll(int[][] grid, Function<int[][], Coordinate> nextStart) {
        Queue<Coordinate> q = new ArrayDeque<>();
        Coordinate start = nextStart.apply(grid);
        int islands = 0;
        while (start != null) {
            grid[start.x][start.y] = WATER;
            q.add(start);
            islands++;
            while (!q.isEmpty()) {
                Coordinate c = q.poll();
                for (int[] d : DELTA) {
                    int nx = c.x + d[0];
                    int ny = c.y + d[1];
                    if (nx < 0 || nx >= grid.length) continue;
                    if (ny < 0 || ny >= grid[0].length) continue;
                    if (grid[nx][ny] == WATER) continue;
                    grid[nx][ny] = WATER;
                    q.add(new Coordinate(nx, ny));
                }
            }
            start = nextStart.apply(grid);
        }
        return islands;
    }

    private Coordinate findBorderIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int x = 0; x < m; x++) {
            if (grid[x][0] == LAND) return new Coordinate(x, 0);
            if (grid[x][n - 1] == LAND) return new Coordinate(x, n - 1);
        }
        for (int y = 0; y < n; y++) {
            if (grid[0][y] == LAND) return new Coordinate(0, y);
            if (grid[m - 1][y] == LAND) return new Coordinate(m - 1, y);
        }
        return null;
    }

    private Coordinate findIsland(int[][] grid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == LAND) return new Coordinate(x, y);
            }
        }
        return null;
    }
}