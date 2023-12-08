import java.util.*;

class Cell {
    public int r, c;

    public Cell(int i, int j) {
        r = i;
        c = j;
    }
}

public class ConnectedCellsInAGrid {

    static int[][] grid;
    static boolean[][] visited;
    static int N, M;
    static boolean isValid(int row, int col) {
        return (row >= 0 && row < N && col >= 0 && col < M);
    }
    static int count_connected(int row, int col) {
        int cnt = 0;
        visited[row][col] = true;

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; ++i) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (isValid(newRow, newCol) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                cnt += count_connected(newRow, newCol);
            }
        }

        return cnt + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }
        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (grid[i][j] == 0 || visited[i][j]) continue;
                int cnt = count_connected(i, j);
                if (max < cnt) max = cnt;
            }
        }

        System.out.println(max);

    }
}
