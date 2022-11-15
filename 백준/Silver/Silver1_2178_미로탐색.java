package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_2178_미로탐색 {
	static int N,M;
	static int[][] map;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r = 0; r < N; r++) {
			char[] line = br.readLine().toCharArray();
			for(int c = 0; c < M; c++) {
				map[r][c] = line[c] - '0';
			}
		}
		//입력 완료
		
		int answer = bfs();
		System.out.println(answer);
	}

	private static int bfs() {
		//1.준비물 
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int depth = 0;
		
		//2. 첫번째 넣기
		q.offer(new int[] {0,0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			depth++;
			
			while(size-- > 0) {
				int[] current = q.poll();
				if(current[0] == N-1 && current[1] == M-1) {
					return depth;
				}
				
				for(int[] delta : deltas) {
					int nr = current[0] + delta[0];
					int nc = current[1] + delta[1];
					if(isIn(nr,nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr,nc});
					}
				}
			}
			
			
		}
		
		
		return 0;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >=0 && nc < M;
	}

}
