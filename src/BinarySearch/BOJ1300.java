package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ1300 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        List<Integer> B = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                B.add(i * j);
            }
        }
        Collections.sort(B);
        System.out.println(B.indexOf(K-1));
    }
}
