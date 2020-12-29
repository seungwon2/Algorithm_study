package DFS;

import java.util.Scanner;

public class BOJ1021 {
    private static int[][] field;
    private static int m, n, k, x, y;
    private static int[] dx = {0, 1, -1, 0};
    private static int[] dy = {1, 0, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 0; t < test; t++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            field = new int[n][m];
            for (int i = 0; i < k; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                field[y][x] = 1;
            }
            System.out.println(solution());
        }
    }
        private static int solution() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        } return count;
    }
    private static void dfs(int i, int j) {
        field[i][j] = 0;
        for (int t = 0; t < 4; t++) {
            if (i + dx[t] >= 0 && i + dx[t] < n &&
                    j + dy[t] >= 0 && j + dy[t] < m) {
                if (field[i + dx[t]][j + dy[t]] == 1)
                    dfs(i + dx[t], j + dy[t]);
            }
        }
    }
}
