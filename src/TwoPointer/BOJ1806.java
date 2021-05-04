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
        int sum = 0;
        while(true){
            if (sum >= S) {
                sum -= numbers[start];
                length = Math.min(length, (end - start));
                start++;
            }
            else if (end == N) {
                break;
            }
            else {
                sum += numbers[end];
                end++;
            }
        }
        if (length == Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else System.out.println(length);
    }
}
