package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1715 {
    public static void main(String[] args) {
        //초기화 및 입력 받아 배열 채우기
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = s.nextInt();
        }

        //numbers 작은 순서로 정렬
        Arrays.sort(numbers);

        int temp = numbers[0];
        int result = 0;
        for (int i = 1; i < N; i++) {
            temp += numbers[i];
            result = result + temp;
        }
        System.out.println(result);
    }
}
