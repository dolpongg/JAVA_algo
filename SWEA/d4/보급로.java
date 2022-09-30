package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 보급로 {
	
	static int[][] deltas = {{0,1}, {1,0}, {-1,0}, {0,-1}};
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int[][] dp = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				char[] line = br.readLine().toCharArray();
				for(int c = 0; c < N; c++) {
					map[r][c] = line[c] - '0';
				}
				Arrays.fill(dp[r], Integer.MAX_VALUE);
			}
			//입력 완료
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {0,0});
			dp[0][0] = 0;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();

				for(int[] delta : deltas) {
					int nr = cur[0] + delta[0];
					int nc = cur[1] + delta[1];
					if(isIn(nr,nc) && dp[cur[0]][cur[1]] + map[cur[0]][cur[1]] < dp[nr][nc]) {
						dp[nr][nc] = dp[cur[0]][cur[1]] + map[cur[0]][cur[1]];
						q.offer(new int[] {nr,nc});
					}
					
					
				}
				
				
			}
			sb.append("#").append(tc).append(" ").append(dp[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb);

	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
