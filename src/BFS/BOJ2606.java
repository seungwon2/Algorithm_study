package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2606 {
    static int computer;
    static int link;
    static int[][] map;
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        computer = s.nextInt();
        link = s.nextInt();
        map = new int[computer + 1][computer + 1];
        visited = new int[computer + 1];

        for (int i = 0; i < link; i++) {
            int from = s.nextInt();
            int to = s.nextInt();
            map[from][to] = 1;
            map[to][from] = 1;
        }
        System.out.println(bfs());
    }
    static int bfs(){
        int count = 0;
        q.add(1);
        visited[1] = 1;

        while (!q.isEmpty()){
            int cur = q.poll();
                for (int i = 0; i < computer + 1; i++) {
                    if (map[cur][i] == 1 && visited[i]==0) {
                        q.add(i);
                        count++;
                        visited[i] = 1;
                    }
                }

        }

        return count;
    }
}
