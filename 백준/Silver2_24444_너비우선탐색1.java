import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author dolpong
 * @date 2022.08.15
 * @url https://www.acmicpc.net/problem/24444
 * @git 
 * @performance 
 * @category BFS
 * @note 출력되는 노드 순서가 아니라, 노드의 출력 순서!
 */

public class Silver2_24444_너비우선탐색1 {
	static int N, M, R;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		List<List<Integer>> G = new ArrayList<>();
		for(int i = 0; i < N+1; i++) {
			G.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			G.get(x).add(y);
			G.get(y).add(x);
		}//입력 완료
		for(int i = 1; i <= N; i++) {
			Collections.sort(G.get(i), Collections.reverseOrder());
		}
		bfs(G, R);

	}
	
	public static void bfs(List<List<Integer>> G, int Start) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		boolean [] visited = new boolean[N+1]; 
		int [] order = new int[N+1];
		int cnt=1;
		visited[Start] = true;
		order[Start] = cnt++;
		queue.offer(Start);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			for(int v : G.get(current)) {
				if(!visited[v]) {
					visited[v] = true;
					order[v] = cnt++;
					queue.offer(v);
				}
			}
			
		}
		
		for(int i  =1 ;i <= N; i++) {
			System.out.println(order[i]);
		}
	}

}
