package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1715 {
    public static void main(String[] args) {
        //작은 숫자 뽑기 위해서 Integer형 priority queue 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //초기화 및 입력 받아 배열 채우기
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            pq.add(s.nextInt());
        }

        //큐에서 가장 작은 숫자부터 뽑아서 계산
        int temp_sum = 0;
        int result = 0;
        while (pq.size() > 1) {
            temp_sum = pq.poll() + pq.poll();
            result = result + temp_sum;
            pq.add(temp_sum);
        }
        System.out.println(result);
    }
}
