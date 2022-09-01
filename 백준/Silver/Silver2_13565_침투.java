package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_13565_침투 {
	static int N, M;
	static int[][] map;
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static boolean answer;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}//입력 완료
		
		answer = false;
		visited = new boolean [N][M];
		for(int c = 0; c < M; c++) {
			if(map[0][c] == 0) {
				dfs(0,c);
				if(answer) break;
			}
		}
		System.out.println(answer ? "YES" : "NO");
	}

	private static void dfs(int r, int c) {
		if(r == N-1) {
			answer = true;
			return;
		}
		
		for(int [] d : deltas) {
			int nr = r + d[0];
			int nc = c + d[1];
			if(isIn(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc);

			}
		}

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
