package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold5_1753_최단경로 {
	static int V,E;
	
	public static class Node implements Comparable<Node>{
		int to,w;

		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		List<Node>[] g = new ArrayList[V+1];
		for(int v = 1; v <= V; v++) {
			g[v] = new ArrayList<>();
		}
		
		int start = Integer.parseInt(br.readLine());
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			g[from].add(new Node(to, w));
		}
		
		//1. 우선순위 큐 생성
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//2. 최소 거리 담을 배열 생성
		int[] minDis = new int[V+1];
		
		//3. 최소 거리 배열 초기화
		Arrays.fill(minDis, Integer.MAX_VALUE);
		
		//4. 첫 노드 인큐
		pq.offer(new Node(start,0));
		minDis[start] = 0;
		
		//4. 큐 빌때까지 돌리기 - 1) 대장 나와 -> 2) 방문 처리 & 종료 처리 -> 3) 자식 노드 탐색 & 인큐 
		while(!pq.isEmpty()) {
			//대장 나와
			Node current = pq.poll();
			
			//자식 탐색
			for(Node n : g[current.to]) {
				if(minDis[n.to] > current.w + n.w) {
					minDis[n.to] = current.w + n.w;
					pq.offer(new Node(n.to, current.w + n.w));
				}
			}
			
		}
		for(int i = 1; i < V+1; i++) {
			System.out.println(minDis[i] == Integer.MAX_VALUE? "INF" : minDis[i]);
		}
		
	}
}
/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/