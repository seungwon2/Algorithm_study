package BinarySearch;

import java.util.Scanner;

public class BOJ1300 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        long left = 1, right = K;
        long ans = 0;

        // 이분 탐색 수행
        while (left <= right) {
            long mid = (left + right) / 2; // 임의의 수 지정
            long cnt = 0;

            // mid보다 작거나 같은 수는 몇 개인지 계산.
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < K) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
