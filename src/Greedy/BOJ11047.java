package Greedy;

import java.util.Scanner;

public class BOJ11047 {
    static int[] wallet;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();

        wallet = new int[N];
        for (int i = 0; i < N; i++) {
            wallet[i] = s.nextInt();
        }

        int index = N-1;
        int count = 0;
        while (true) {
            if(K==0) break;
            if (K < wallet[index]) {
                index = index - 1;
            }
            else {
                K = K - wallet[index];
                count = count + 1;
            }
        }
        System.out.println(count);
    }
}

