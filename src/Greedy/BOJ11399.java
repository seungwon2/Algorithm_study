package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {
    public static void main(String[] args) {
        //변수 선언 및 배열 값 넣기
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            people[i] = s.nextInt();
        }

        //배열 작은 값부터 순서대로 정렬
        Arrays.sort(people);

        //기다린 시간 계산 - 누적으로 계산됨!
        int temp = 0;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            temp += people[i - 1];
            result += temp;
        }
        System.out.println(result);
    }
}
