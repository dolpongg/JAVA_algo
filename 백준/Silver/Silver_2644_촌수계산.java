package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver_2644_촌수계산 {
	static int end, answer = -1;
	static boolean[] visited;
	static List<List<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	        int n = Integer.parseInt(br.readLine()); 
	        visited = new boolean[n + 1];
	        for (int i = 0; i <= n; i++) {
	        	graph.add(new ArrayList<>());
	        }
	 
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int start = Integer.parseInt(st.nextToken());
	        end = Integer.parseInt(st.nextToken());
	 
	        int m = Integer.parseInt(br.readLine());
	        
	        for (int i = 0; i < m; i++) {
	            st = new StringTokenizer(br.readLine());
	            int from = Integer.parseInt(st.nextToken());
	            int to = Integer.parseInt(st.nextToken());
	            graph.get(from).add(to);  
	            graph.get(to).add(from);  
	        }//입력 완료 
	        
	        //방문 처리 1 : 첫번째 노드 방문 처리 
	        dfs(start, 0);
	        System.out.println(answer);
	    }
	 
	    private static void dfs(int node, int cnt) {
	        visited[node] = true;// 방문 처리 2
	        
	        for (int x : graph.get(node)) {
	            if (!visited[x]) { 
	            	//방문 처리 1
	                if (x == end) { 
	                    answer = cnt + 1;
	                    return;
	                }
	                //다음 촌수
	                dfs(x, cnt + 1);
	            }
	        }
	    }
	
}
