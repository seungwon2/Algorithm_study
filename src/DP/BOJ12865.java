package DP;

import java.util.Scanner;

public class BOJ12865 {
    static int[] dp;
    static int[] weight;
    static int[] value;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        weight = new int[N];
        value = new int[N];

        for (int i = 0; i < N; i++) {
            weight[i] = s.nextInt();
            value[i] = s.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += weight[i];
        }
        dp = new int[sum + 1];

        for (int i = 0; i < N; i++) {
            for (int j = sum; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        int max = 0;
        for (int i = 0; i <= K; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
