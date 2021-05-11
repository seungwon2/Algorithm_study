package EPPER;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EPPER_15_6 {
    public static void main(String[] args) {
        Deque<String> dequeue = new ArrayDeque<>();
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            dequeue.add(s.next());
        }

        //두 숫자 연산을 하니까 두 개를 뽑아서 저장하려고 선언 먼저
        String e1 = null;
        String e2 = null;
        //스택에 요소가 있을 때 계속 반복
        while (!dequeue.isEmpty()) {
            //맨 앞 요소를 뽑아서 검사
            String cur = dequeue.removeFirst();
            //switch문으로 검사, 우선 연산자일 경우 각각 계산하도록 처리한다
            switch (cur) {
                case "*":
                    //먼저 string으로 넣어놨으니까 Integer.parseInt로 숫자로 바꿈
                    int temp = Integer.parseInt(e1) * Integer.parseInt(e2);
                    //바꾼 다음 연산한 값을 덱의 맨 처음에 넣는다.
                    dequeue.addFirst(String.valueOf(temp));
                    e1 = e2 = null;
                    break;
                case "/":
                    temp = Integer.parseInt(e1) / Integer.parseInt(e2);
                    dequeue.addFirst(String.valueOf(temp));
                    e1 = e2 = null;
                    break;
                case "+":
                    temp = Integer.parseInt(e1) + Integer.parseInt(e2);
                    dequeue.addFirst(String.valueOf(temp));
                    e1 = e2 = null;
                    break;
                case "-":
                    temp = Integer.parseInt(e1) - Integer.parseInt(e2);
                    dequeue.addFirst(String.valueOf(temp));
                    e1 = e2 = null;
                    break;
                default:
                    if (e1 == null) {
                        e1 = cur;
                    }
                    else if (e2 == null) {
                        e2 = cur;
                    }
                    if (dequeue.size() == 0) {
                        System.out.println(cur);
                        break;
                    }
                    break;
            }
        }
    }
}
