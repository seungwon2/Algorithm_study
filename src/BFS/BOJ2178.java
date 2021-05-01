package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] isVisited;
    static int N;
    static int M;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        M = s.nextInt();

        map = new int[N][M];
        isVisited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = s.next().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        bfs();
    }
    static void bfs(){
        q.add(map[0][0]);
        isVisited[0][0] = 1;

        int nx = 0, ny = 0;

        while(!q.isEmpty()){
            q.poll();
            for (int i = 0; i < 4; i++) {
                if (nx + dx[i] < M && nx + dx[i] >= 0 && ny + dy[i] >= 0 && ny + dy[i] < N && map[nx + dx[i]][ny + dy[i]] == 1
                        && isVisited[nx + dx[i]][ny + dy[i]] == 0) {
                    q.add(map[nx + dx[i]][ny + dy[i]]);
                    isVisited[nx + dx[i]][ny + dy[i]] = 1;
                    map[nx + dx[i]][ny + dy[i]] = map[nx][ny] + 1;
                }
            }
        }

        System.out.println("map = " + map[N][M]);


    }
}
