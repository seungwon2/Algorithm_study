package DP;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class BOJ14501 {
    static int[][] pay;
    static int day;
    static int[] memo;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        day = s.nextInt();
        pay = new int[day + 1][2];
        for (int i = 1; i < day+1; i++) {
            pay[i][0] = s.nextInt();
            pay[i][1] = s.nextInt();
        }

        memo = new int[day + 1];
        for (int i = 0; i < day + 1; i++) {
            memo[i] = -1;
        }
        DP(pay);
    }
    static void DP(int[][] pay) {
        for (int i = 1; i <= day; i++) {
            int temp = i;
            int total_pay = 0;
            while (true) {
                int working_day = pay[temp][0];
                int payment = pay[temp][1];
                temp = temp + working_day;
                if (temp > day) {
                    memo[i] = total_pay;
                    break;
                }
                total_pay = total_pay + payment;
            }
        }

        int max = 0;
        for (int i = 1; i < day + 1; i++) {
            max = max(max, memo[i]);
        }
        System.out.println(max);
    }
}
