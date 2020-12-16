package DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class BOJ2606 {
    static int computer, Link;
    static int map[][];
    static int result;
    static int visited[];
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        computer = scanner.nextInt();
        Link = scanner.nextInt();

        map = new int[computer+1][computer+1];
        visited = new int[computer+1];

        for (int i = 0; i < Link; i++) {

            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            map[node1][node2] = map[node2][node1] = 1;
        }
        dfs(1);
        System.out.println(result);
    }


    static void dfs(int start)
    {
        visited[start] = 1;

        for(int i=1;i<computer+1;i++)
        {
            if(map[start][i] == 1 && visited[i] == 0)
            {
                dfs(i);
                result++;
            }
        }
    }

}

