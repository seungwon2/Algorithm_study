package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576 {
    static int N;
    static int M;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Dot {
        int x;
        int y;
        int day;

        public Dot(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        M = s.nextInt();

        box = new int[M][N];
        //박스 map을 만든다
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                box[i][j] = s.nextInt();
            }
        }
        //bfs 돌리기
        bfs();
    }

    static void bfs() {
        Queue<Dot> q = new LinkedList<Dot>();
        int day = 0;

        // 토마토가 있는 좌표 찾아서 Queue에 넣기
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                //만약 익은 토마토가 있다면 큐에 넣는다
                if(box[i][j] == 1)
                    q.offer(new Dot(i, j, 0));
            }
        }

        // bfs 시작
        while(!q.isEmpty()) {
            //큐에 있는 토마토 꺼냄
            Dot dot = q.poll();
            //토마토 일수
            day = dot.day;
            //사방을 검사
            for(int i=0; i<4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];

                if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if(box[nx][ny] == 0) {
                        //익게 만든다 호호
                        box[nx][ny] = 1;
                        //새로운 토마토를 큐에 넣음
                        q.add(new Dot(nx, ny, day+1));
                    }
                }
            }
        }

        // 토마토가 다 익었는지 확인
        if(checkTomato())
            System.out.println(day);
        //다 안익었으면 -1을 출력
        else
            System.out.println(-1);
    }

    // box 배열에 0이 남아있다면 false, 아니면 true
    static boolean checkTomato() {
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(box[i][j] == 0)
                    return false;
            }
        }

        return true;
    }
}
