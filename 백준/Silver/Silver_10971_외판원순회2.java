package Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

@author 은서파
@since 2022. 8. 25.
@see
@git
@youtube
@performance
@category #
@note */
public class Silver_10971_외판원순회2{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static long answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}//입력 
		
		visited = new boolean[N];
		answer = Integer.MAX_VALUE; //최종 출력 정답
		visited[0] = true;
		answer = dfs(0, 0, 1);
		System.out.println(answer);
	}
	
	static int dfs(int node, int sum, int depth) {
		//종료 조건
		if(depth == N) {
			if(map[node][0] == 0) {
				return Integer.MAX_VALUE;
			}
			return sum + map[node][0];
		}
		
		int tmp = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && map[node][i] != 0) {
				visited[i] = true;
				tmp = Math.min(tmp, dfs(i,sum + map[node][i],depth+1));
				visited[i] = false;
			}
			
		}
		
		return tmp;
		
	}
	
}