package DivideandConquer;

import java.io.BufferedReader;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BOJ6549 {
    static int num;
    static int right;
    static int left;
    static int result = 0;
    static int[] height;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            num = scanner.nextInt();
            if (num==0) break;
            height = new int[num];
            for (int i = 0; i < num; i++) {
                height[i] = scanner.nextInt();
            }
            System.out.println(divide(height));
        }

    }
    static int divide(int[] height){
        int length = height.length;
        for(left=0;left<length;left++){
            int minHeight = height[left];
            for(right=left; right<length; right++){
                minHeight = min(minHeight, height[right]);
                result = max(result, (right - left + 1) * minHeight);
            }
        }
        return result;
    }

}
