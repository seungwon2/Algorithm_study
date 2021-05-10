package EPPER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EPPER_15_4 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = s.nextInt();
            sum += numbers[i];
        }
        System.out.println(solution(numbers));
    }

    static List<Integer> solution(int[] numbers) {
        List<Integer> answer = new ArrayList<>(7);
        for (int i = 0; i < 9; i++) {
            int total = sum;
            for (int j = i; j < 9; j++) {
                int temp_sum = 0;
                temp_sum = total - numbers[i] - numbers[j];
                if (temp_sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        answer.add(numbers[k]);
                    }
                }
            }
        }
        return answer;
    }
}
