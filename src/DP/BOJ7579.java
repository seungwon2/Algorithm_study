package DP;

import java.util.Scanner;

public class BOJ7579 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int memory[] = new int[N+1];
        int cost[] = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            memory[i] = s.nextInt();
        }
        for (int i = 1; i < N+1; i++) {
            cost[i] = s.nextInt();
        }
        int result = 0;
        while(true){
            if (M <= 0) {
                break;
            }

            int tag = 1;
            int min = cost[1];
            for (int i = 1; i < N+1; i++) {
                if (cost[i] <= min) {
                    min = cost[i];
                    tag = i;
                }
            }
            M = M - memory[tag];
            result = result + cost[tag];
            cost[tag] = Integer.MAX_VALUE;

        }
        System.out.println(result);
    }
}
