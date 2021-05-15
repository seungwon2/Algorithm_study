package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1987 {
    static char[] dic;
    static int[] visited;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        dic = new char[M];
        visited = new int[M];
        String[] map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = s.nextLine();
        }
        bfs(map);


    }
    static boolean check(char k){
        for (int i = 0; i < dic.length; i++) {
            if (dic[i] == k) {
                return false;
            }
        }
        return true;
    }
    static int bfs(String[] map){
        Queue<String> q = new LinkedList<String>();

        int result = 0;

        q.add(map[0][0]);
    }
}
