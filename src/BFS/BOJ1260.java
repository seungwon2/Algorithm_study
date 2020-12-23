package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {
    static int[][] isConnected;
    static boolean[] visited;
    static int n;
    static int m;
    static int start;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        isConnected = new int[1001][1001];
        visited = new boolean[1001];

        for(int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            isConnected[x][y] = isConnected[y][x] = 1;
        }

        dfs(start);

        visited = new boolean[1001];
        System.out.println();

        bfs();
    }

    public static void dfs(int i) {
        visited[i] = true;
        System.out.print(i + " ");

        for(int j = 1; j <= n; j++) {
            if(isConnected[i][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int j = 1; j <= n; j++) {
                if(isConnected[temp][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
