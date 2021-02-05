package DivideandConquer;

import java.io.BufferedReader;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BOJ6549 {
    static int num;
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
            System.out.println(divide(0,height.length-1));
        }

    }
    static int divide(int left, int right){
        //기저 사례: 판자 1개일때
        if(left==right){
            return height[left];
        }

        //오른쪽이나 왼쪽 사각형 각개격파
        int mid = (right + left) / 2;
        int result = max(divide(left, mid), divide(mid+1, right));

        //걸쳐진 사각형 계산
        //lo, hi 설정
        int lo = mid;
        int hi = mid + 1;
        int minHeight = min(height[lo], height[hi]);
        //mid와 mid+1만 포함하는 사각형 넓이 고려!
        result = max(result, minHeight * 2);

        //left와 right 범위 안에 있을 때 모든 경우 스캔
        while (lo > left || hi < right) {

            //right 쪽으로 확장할 경우
            if (hi < right && (lo == left || height[lo - 1] < height[hi + 1])) {
                hi++;
                minHeight = min(minHeight, height[hi]);
            }
            else {
                lo--;
                minHeight = min(minHeight, height[lo]);
            }
            //확장 후 사각형 넓이
            result = max(result, minHeight * (hi - lo + 1));
        }

        return result;
    }

}
