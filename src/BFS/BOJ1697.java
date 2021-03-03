package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {
    static int N;
    static int K;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        K = s.nextInt();

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        //큐에 넣음
        q.add(num);
        //방문 체크
        check[num] = 1;

        while (!q.isEmpty()) {
            //큐에서 꺼냄
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                //세번 시도한다
                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }
                //동생한테 도달했을 때
                if (next == K) {
                    //체크해놓은걸 프린트
                    System.out.println(check[temp]);
                    return;
                }
                //조건에 맞는다면 또 큐에 next를 넣고, next는 지금보다 한번 더 시도한 거니까 check[temp]+1로 설정한다
                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }
    }
}
