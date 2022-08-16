import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3_2606_바이러스 {
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //컴퓨터 수
		M = Integer.parseInt(br.readLine()); //간선 수
		
		List<List<Integer>> G = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			G.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			G.get(x).add(y);
			G.get(y).add(x);
		}
		
		for(int i = 1; i <= N; i++) {
			Collections.sort(G.get(i));
		}
		
		bfs(1, G);
	}

	
	public static void bfs(int Start, List<List<Integer>> G) {
		boolean [] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		int cnt = -1;
		
		q.offer(Start);
		visited[Start] = true;
		
		while(!q.isEmpty()) {
			cnt++;
			int current = q.poll();
			
			for(int v : G.get(current)) {
				if(!visited[v]) {
					visited[v] = true;
					q.offer(v);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt);
		System.out.println(sb);
		
		
	}
}
