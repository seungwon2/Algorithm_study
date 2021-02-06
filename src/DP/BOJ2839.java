package DP;

import java.util.Scanner;

import static java.lang.Math.min;

public class BOJ2839 {
    static int sugar;
    static int[] memo;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        sugar = s.nextInt();
        //배열 크기 정하기
        int length = sugar / 5;

        //메모 배열 초기화
        memo = new int[length+1];
        for (int i = 0; i <= length; i++) {
            memo[i] = -1;
        }

        //메모하기
        for (int i = 0; i <= length; i++) {
            int temp = sugar - (5 * i);
            if (temp % 3 == 0) {
                memo[i] = temp / 3;
            }
        }

        //배열 최소값 찾기
        int min = 1001;
        int index = 0;
        for (int i = 0; i <= length; i++) {
            if (memo[i] != -1) {
                int lastmin = min;
                min = min(min, memo[i]);
                if (lastmin != min) {
                    index = i;
                }
            }
        }
        //최소 값 출력
        if (min == 1001) {
            System.out.println(-1);
        }
        else{
            System.out.println(min + index);
        }

    }
}
