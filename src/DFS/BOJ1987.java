package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    public static int ROW;
    public static int COL;
    public static int[][] arr;

    public static int[] dy = {-1, 1, 0, 0}; // 상하 좌우;
    public static int[] dx = {0, 0, -1, 1};

    public static boolean[] visited;

    public static int step = 1;
    public static int max_step = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());
        arr = new int[ROW][COL];

        for(int i=0; i < ROW; i++) {
            String str = br.readLine();
            for(int j=0; j < COL; j++) {
                arr[i][j] = (int)str.charAt(j) - 65;
            }
        }

        //알파벳이 26개니까
        visited = new boolean[26];
        dfs(0, 0);
        System.out.println(max_step);
    }

    public static void dfs(int y, int x) {
        int alpha = arr[y][x];
        visited[alpha] = true;

        for(int i=0; i < 4; i++) {
            //옮긴 좌표 xx, yy
            int yy = dy[i] + y;
            int xx = dx[i] + x;

            //범위 밖이면 넘어감
            if(yy < 0 || xx < 0 || yy >= ROW || xx >= COL) continue;

            //범위 안이면 해당 alpha를 뽑아옴
            int nextAlpha = arr[yy][xx];
            //이미 방문했던거면 넘어감
            if(visited[nextAlpha]) continue;

            //방문한거 아니면 step을 올려줌
            max_step = Math.max(max_step, ++step);

            //dfs옮긴 좌표로 또 실시
            dfs(yy, xx);
        }
        // 여기서 초기화 하지 않으면 다른 경로에서 접근 할 수 없다.
        step --;
        visited[alpha] = false;
    }
}

