package DivideandConquer;

import java.util.Scanner;

public class BOJ5904 {
    static int num;
    static char answer;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        num = s.nextInt();
        moo(num);
        System.out.println(answer);
    }

    static void moo(int num) {
        int size = 3;
        int index = 0;
        if (num == 1) {
            answer = 'm';
        }
        else if (num <= 3) {
            answer = 'o';
        }
        else {
            while (size < num) {
                size = size * 2 + index + 4;
                index++;
            }
            int front_back = (size - index - 3) / 2;
            if (size - front_back + 1 <= num) {
                moo(num - size + front_back);
            }
            else if (num == front_back + 1){
                answer = 'm';
            }
            else{ answer = 'o';
            }
        }

    }

}
