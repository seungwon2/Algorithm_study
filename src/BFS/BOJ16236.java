package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236 {

    public static final int max_val = 401, max_int = 21;
    public static int n, shark_x, shark_y, min_dist, min_x, min_y, result, eat_cnt = 0, shark_size = 2;
    public static int [][] map, check;
    public static int [] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        check = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                //상어 위치 구하고 0으로 처리
                if(map[i][j] == 9){
                    shark_x = i;
                    shark_y = j;
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            init_check();

            bfs(shark_x, shark_y);
            //min_x와 y가 n배열 안에 있다면 결과값에 1을 더하고 eat count를 올림
            //eat count가 현재 상어 사이즈와 똑같다면 상어 사이즈를 늘림
            if(min_x != max_int && min_y != max_int){
                result += check[min_x][min_y];

                eat_cnt++;

                if(eat_cnt == shark_size){
                    shark_size++;
                    eat_cnt = 0;
                }
                //물고기 먹었으니 0으로 바꿈
                map[min_x][min_y] = 0;
                //상어 이동
                shark_x = min_x;
                shark_y = min_y;
            }

            else{
                break;
            }
        }

        System.out.println(result);
    }

    public static void init_check(){
        min_dist = max_val;
        min_x = max_int;
        min_y = max_int;

        //방문했으면 i,j를 체크함
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                check[i][j] = -1;
            }
        }
    }

    public static void bfs(int x, int y){
        Queue<info> q = new LinkedList<info>();
        check[x][y] = 0;
        q.add(new info(x, y));

        while(!q.isEmpty()){
            //현재 위치 cur 뽑아옴
            info cur = q.poll();
            x = cur.x;
            y = cur.y;

            for(int i=0; i<4; i++){
                //사방 좌표 옮기면서 탐색 시작
                int nx = x + dx[i];
                int ny = y + dy[i];

                //n에서 벗어나면 넘김
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                //이미 방문했거나 상어 크기보다 크면 못먹으니 무시
                if(check[nx][ny] != -1 || map[nx][ny] > shark_size) continue;

                //한번 움직이니까
                check[nx][ny] = check[x][y] + 1;

                //상어가 먹을 수 있고 빈 공간이 아니라면 물고기 먹는거 실행
                if(map[nx][ny] != 0 && map[nx][ny] < shark_size){
                    //가장 가까운 물고기라면 먹음
                    if(min_dist > check[nx][ny]){
                        min_x = nx;
                        min_y = ny;
                        min_dist = check[nx][ny];
                    }
                    //가장 가까운 물고기가 여러마리 있을 경우
                    else if(min_dist == check[nx][ny]){
                        //가장 위쪽에 있다면, 가장 왼쪽에 있는지 살펴봄
                        if(min_x == nx){
                            if(min_y > ny){
                                min_x = nx;
                                min_y = ny;
                            }
                        }
                        //가장 위쪽인지 살펴봄
                        else if(min_x > nx){
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                }
                //queue에 현재 위치 정보 넣음
                q.add(new info(nx, ny));
            }
        }

    }
}

class info{
    int x, y;

    info(int x, int y){
        this.x = x;
        this.y = y;
    }
}
