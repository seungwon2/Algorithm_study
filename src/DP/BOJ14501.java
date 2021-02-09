package DP;

import java.util.Scanner;

import static java.lang.Math.max;

public class BOJ14501 {
    static int[][] pay;
    static int day;
    static int[] memo;
    public static void main(String[] args) {
        //입력 배열로 정돈해서 받기
        Scanner s = new Scanner(System.in);
        day = s.nextInt();
        pay = new int[day + 1][2];
        for (int i = 1; i < day+1; i++) {
            pay[i][0] = s.nextInt();
            pay[i][1] = s.nextInt();
        }

        //메모 초기화
        memo = new int[day + 1];
        for (int i = 0; i < day + 1; i++) {
            memo[i] = -1;
        }
        DP(pay);
    }
    static void DP(int[][] pay) {
        //첫 날부터 마지막 날까지 쭉 검사
        for (int i = 1; i <= day; i++) {
            int working_day = pay[i][0];
            int today_pay = pay[i][1];
            int start_day;
            int today = i;
            int total_pay = 0;

            //해당 날에 시작해서 근무를 끝마치지 못한다면 검사할 필요 없음
            if (today + working_day > day) {
                continue;
            }
            //근무 끝나는 날까지 계속 반복문 돌며 수입 출력
            else {
                while (true) {
                    start_day = today + working_day;
                    //기저 사례: 새로 시작하는 날이 총 근무일보다 크면
                    if (start_day-1 ==day){
                        memo[i] = total_pay + today_pay;
                        break;
                    }
                    else if (start_day > day) {
                        //해당 날까지의 총액을 메모하고 끝냄
                        memo[i] = total_pay;
                        break;
                    }
                    else {
                        //아닐 경우 그날 페이를 total_pay에 더함
                        total_pay = total_pay + today_pay;
                        //마지막날을 오늘로 해서 검사함
                        today = start_day;
                        today_pay = pay[today][1];
                        working_day = pay[today][0];
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i < day + 1; i++) {
            max = max(max, memo[i]);
        }
        System.out.println(max);
    }

}
