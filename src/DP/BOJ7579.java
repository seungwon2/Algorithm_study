package DP;

import java.util.Scanner;

import static java.lang.Math.max;

public class BOJ7579 {
    public static void main(String[] args) {
        //값 입력 받기
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int sum = 0;
        int memory[] = new int[N];
        int cost[] = new int[N];

        for (int i = 0; i < N; i++) {
            memory[i] = s.nextInt();
        }
        for (int i = 0; i < N; i++) {
            cost[i] = s.nextInt();
            sum += cost[i];
        }
        int dp[] = new int[sum + 1];

        //memo[index], index는 cost, value는 확보한 메모리
        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= cost[i]; j--) {
                dp[j] = max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }
        for (int i = 0; i <= sum; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }

}
