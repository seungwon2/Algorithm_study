package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int row;
    int col;

    public Virus(int row, int col) {
        super();
        this.row = row;
        this.col = col;
    }

}

public class BOJ14502 {

    static int N, M, max; // 가로 세로 최대값
    static int[][] map; // 입력받는 맵
    static int[][] wall; // 벽을 놓을 맵
    static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dx = { 0, 0, -1, 1 };
    static ArrayList<Virus> virusList;

    // 범위 검사
    public static boolean isValid(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    // map 깊은 복사
    public static int[][] copy(int [][] arr) {

        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            if (M >= 0) System.arraycopy(arr[i], 0, copy[i], 0, M);
        }
        return copy;
    }

    // 벽을 세우는 경우
    public static void makeWall(int depth) {

        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (wall[i][j] == 0) { // 빈칸인 경우
                    wall[i][j] = 1; // 벽 건설
                    makeWall(depth + 1);
                    wall[i][j] = 0; // 다음 경우의 수를 위해 복구
                }
            }
        }
    }

    // 벽을 세웠을 경우, virus 전염
    private static void spreadVirus() {

        int[][] copyWall = copy(wall); // 바이러스를 확장 시킬 복사 맵

        // virus를 담는 과정
        Queue<Virus> vq = new LinkedList<>(); // virus를 담는 큐
        for (Virus virus : virusList) {
            vq.offer(new Virus(virus.row, virus.col));
        }

        // virus 전염 시작
        while (!vq.isEmpty()) {
            int row = vq.peek().row;
            int col = vq.poll().col;

            for (int k = 0; k < 4; k++) {
                int nextRow = row + dy[k];
                int nextCol = col + dx[k];

                // 범위 && 빈칸인 경우
                if (isValid(nextRow, nextCol) && copyWall[nextRow][nextCol] == 0) {
                    copyWall[nextRow][nextCol] = 2;
                    vq.offer(new Virus(nextRow, nextCol));
                }

            }
        } // end of spread

        // 안전구역 크기 체크 후 비교
        int sc = countSafe(copyWall);
        max = Math.max(max, sc);
    }

    // 안전구역 크기
    public static int countSafe(int[][] copyWall) {
        int sc = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyWall[i][j] == 0) {
                    sc++;
                }
            }
        }
        return sc;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        virusList = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 입력을 받으면서 바이러스 초기값 탐색
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        } // end of input

        // 3개의 벽을 세우기 위한 copy map
        wall = copy(map);

        // 벽 세우기 시작
        makeWall(0);

        System.out.println(max);
    } // end of main

}