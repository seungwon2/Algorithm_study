package TwoPointer;

import java.util.Scanner;

public class BOJ1806 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int start = 0;
        int end = 0;
        int N = s.nextInt();
        int S = s.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = s.nextInt();
        }
        int length = Integer.MAX_VALUE;
        while (start < N && end < N) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += numbers[i];
            }
            if (sum < S) {
                end++;
            } else {
                length = Math.min(length, end - start + 1);
                start++;
                if (end < start) {
                    end++;
                }
            }
        }
        System.out.println(length);
    }
}
