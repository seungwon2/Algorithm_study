package Tree;

import java.util.Scanner;

public class BOJ2042 {
    static int[] numbers;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        numbers = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            numbers[i] = s.nextInt();
        }
        for (int i = 0; i < M+K; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            sum(a, b, c);
        }
    }

    static void sum(int a, int b, int c) {
        if(a==1){
            numbers[b] = c;
        }
        else if(a==2){
            int result = 0;
            for (int i = b; i <= c; i++) {
                result = result + numbers[i];
            }
            System.out.println(result);
        }
    }
}
