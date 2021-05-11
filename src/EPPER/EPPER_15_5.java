package EPPER;

import java.util.Scanner;

public class EPPER_15_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String src = s.next();
        System.out.println(solution(src.length(), src));
    }

    static StringBuilder solution(int m, String input) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        char prev = 0;

        for (int i = 0; i < m; i++) {
            //맨 처음 1과 0 판별
            if (i == 0) {
                if(input.charAt(0) == '1'){
                    answer.append("1");
                }
                prev = input.charAt(0);
                count += 1;
            }
            //이전 값과 같으면 count만 올림
            else if (prev == input.charAt(i)) {
                count += 1;
            }
            //이전 값과 다르면 count 리셋하고 값만큼 알파벳을 올려서 string에 추가
            else {
                answer.append(Character.toString((char) count + 64));
                prev = input.charAt(i);
                count = 1;
            }
        }
        //마지막에 남아있는 count를 알파벳으로 변환!
        answer.append(Character.toString((char) count + 64));
        return answer;
    }
}
