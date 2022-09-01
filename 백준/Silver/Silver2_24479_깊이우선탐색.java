package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_24479_깊이우선탐색 {
	static int N, M, CNT;
	static List<List<Integer>> G;
	static int [] order;
	static boolean [] visited;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Start = Integer.parseInt(st.nextToken());
		
		G = new ArrayList<>();
		for(int i = 0; i < N+1; i++) {
			G.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			G.get(x).add(y);
			G.get(y).add(x);
		}//입력 완
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(G.get(i), Collections.reverseOrder());
		}
		
		order = new int[N+1];
		visited = new boolean[N+1];
		
		dfs(Start);
		for(int i = 1; i <= N; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb);

	}

	public static void dfs(int node) {
		visited[node] = true;
		order[node] = ++CNT;
		
		for(int n : G.get(node)) {
			if(!visited[n]) {
				visited[n] = true;
				dfs(n);
			}
		}
		
	}
}
