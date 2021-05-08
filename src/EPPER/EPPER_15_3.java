package EPPER;

import java.util.Scanner;

public class EPPER_15_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        System.out.println(solution(n, m));
    }
    static int solution(int n, int m) {
        int answer = 0;
        while (n > 0) {
            n--;
            if (answer >= m && answer % m == 0) {
                n ++;
            }
            answer++;
        }
        return answer;
    }
}
