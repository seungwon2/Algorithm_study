package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
    static int V,E,Start,INF=Integer.MAX_VALUE;
    static int dist[];
    static ArrayList<Point> arrList[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arrList = new ArrayList[V+1];
        dist = new int[V+1];
        for(int i=1; i<=V; i++)
            arrList[i] = new ArrayList<>();
        for(int i=1; i<=V; i++)
            dist[i] = INF;

        Start = Integer.parseInt(br.readLine());
        dist[Start] = 0;

        for(int e=0; e<E; e++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            arrList[u].add(new Point(v, val));
        }
        solve();
        for(int i=1; i<=V; i++) {
            if(dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }

    public static void solve() {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // PriorityQueue = (Vertex, weight)
        pq.add(new Point(Start, 0));

        while(!pq.isEmpty()) {
            Point po = pq.poll();

            // 갱신하려고 하는 값이 PQ에서 poll한 노드의 값보다 작을 땐 갱신 X
            if(dist[po.vertex] < po.val)
                continue;

            // 현재 노드에 연결된 Vertex가 저장 된 ArrayList를 반복문을 통해 탐색하며 더 작은 값으로 갱신할 수 있다면 갱신하면서 PQ에 넣어준다.
            for(int i=0; i<arrList[po.vertex].size(); i++) {
                int tmpIndex = arrList[po.vertex].get(i).vertex;
                int tmpDist = po.val + arrList[po.vertex].get(i).val;

                if(dist[tmpIndex] > tmpDist) {
                    dist[tmpIndex] = tmpDist;
                    pq.add(new Point(tmpIndex, tmpDist));
                }
            }
        }
    }

    // 우선순위큐를 편하게 사용하기 위해 정렬기준 변경
    public static class Point implements Comparable<Point>{
        int vertex;
        int val;
        public Point(int v, int val) {
            this.vertex=v;
            this.val=val;
        }
        @Override
        public int compareTo(Point o) {
            if(this.val > o.val)
                return 1;
            // TODO Auto-generated method stub
            return 0;
        }

    }
}

