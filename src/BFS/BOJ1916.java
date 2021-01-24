package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1916 {
    static int N;
    static int M;
    static int START;
    static int END;
    static int[][] maps;
    static long[] cost;
    static boolean[] checked;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maps = new int[N + 1][N + 1];

        // 경로 맵 초기화
        for (int[] arr : maps)
            Arrays.fill(arr, -1);

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            if (maps[from][to] == -1) {
                maps[from][to] = cost;
            } else if (maps[from][to] > cost)
                maps[from][to] = cost;
        }

        START = sc.nextInt();
        END = sc.nextInt();

        sc.close();

        cost = new long[N + 1];
        checked = new boolean[N + 1];

        //초기화
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.MAX_VALUE - 1;
            checked[i] = false;
        }

        //시작점-시작점의 거리는 0
        cost[START] = 0;

        for (int k = 0; k < N - 1; k++) {
            //min, from 선언과 초기화
            long min = Integer.MAX_VALUE;
            int from = -1;

            // 아직 가지 않은 경로 중 최소값 확인
            for (int i = 1; i <= N; i++) {
                if (checked[i] == false && min > cost[i]) {
                    min = cost[i];
                    from = i;
                }
            }

            checked[from] = true;
            //cost[to]는 from에서 to 노드로 가는 비용을 의미
            //from 고정이라 이런식으로 설계
            for (int to = 1; to <= N; to++) {
                // 경로 없음이 아님          && cost[from]이 초기값이랑 똑같음
                //&& cost[to]가 cost[from] + maps[from][to]보다
                if (maps[from][to] != -1 && cost[from] != Integer.MAX_VALUE - 1
                        && cost[to] > cost[from] + maps[from][to]) {
                    cost[to] = cost[from] + maps[from][to];
                }
            }
        }

        System.out.println(cost[END]);
    }
}
