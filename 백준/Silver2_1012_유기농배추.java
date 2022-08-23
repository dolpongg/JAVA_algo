import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_1012_유기농배추 {
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}//입력 끝
			
			boolean[][] visited = new boolean[N][M];
			int answer = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(!visited[r][c] && map[r][c] == 1) {
						Queue<int[]> q = new LinkedList<>();
						
						q.offer(new int[] {r,c});
						visited[r][c] = true;
						
						while(q.size() != 0) {
							int[] current = q.poll();
							
							for(int[] delta : deltas) {
								int nr = current[0] + delta[0];
								int nc = current[1] + delta[1];
								if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == 1) {
									visited[nr][nc] = true;
									q.offer(new int[] {nr,nc});
								}
							}
						}
						answer++;
					}
				}
			}
			System.out.println(answer);
			
			
			
		}

	}

	private static boolean isIn(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}

}
