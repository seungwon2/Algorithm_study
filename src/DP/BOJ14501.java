package DP;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class BOJ14501 {
    static int[][] pay;
    static int day;
    static int[] memo;
    static int max = 0;
    public static void main(String[] args) {
        //입력 배열로 정돈해서 받기
        Scanner s = new Scanner(System.in);
        day = s.nextInt();
        pay = new int[day + 10][2];
        for (int i = 1; i < day+1; i++) {
            pay[i][0] = s.nextInt();
            pay[i][1] = s.nextInt();
        }
        //메모 선언
        memo = new int[day + 10];
        //DP돌림
        DP(pay);
    }
    static void DP(int[][] pay) {
        for (int i = 1; i <=day+1; i++) {
            //이전까지의 최대 수입을 비교해서 최대 수입을 현재에도 저장해준다.
            //이전에 최대수입이 났을 수 있으므로
            //ex) 3,7,(5 예상) 이라고 하면 5의 값은 7로 바꿔주는게 최대수입을 얻는데 맞다.
            memo[i] = max(memo[i], max);
            //이전에 저장된 최대수익 vs 이번 움직임으로 생긴 최대 수익
            memo[pay[i][0]+i] = max(memo[pay[i][0]+i],pay[i][1]+memo[i]);
            //출력될 최대 수입
            max = max(max, memo[i]);
        }
        System.out.println(max);
    }

}

