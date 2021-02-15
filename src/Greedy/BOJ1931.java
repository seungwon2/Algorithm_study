package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1931 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[][] timetable = new int[N][2];
        for (int i = 0; i < N; i++) {
            timetable[i][0] = s.nextInt();
            timetable[i][1] = s.nextInt();
        }

        //timetable 정렬 다시 정의
        Arrays.sort(timetable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int result = 0;
        int end_time = 0;
        for (int i = 0; i < N; i++) {
            if (timetable[i][0] >= end_time) {
                end_time = timetable[i][1];
                result++;
            }
        }
        System.out.println(result);


    }
}
