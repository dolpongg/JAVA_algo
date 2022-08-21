import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_2178_미로탐색 {

	static int N,M;
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[N+1][M+1];
		
		for(int r = 1; r <= N; r++) {
			String line = br.readLine();
			for(int c = 1; c <= M; c++) {
				map[r][c] = line.charAt(c-1) - '0';
			}
		}//입력 완료
		
		boolean[][] visited = new boolean [N+1][M+1];
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1,1,1});
		int answer = 0;
		
		while(q.size() != 0) {
			int [] current = q.poll();
			
			if(current[0] == N && current[1] == M) {
				answer = current[2];
				break;
			}
			
			for(int [] delta : deltas) {
				int nr = current[0] + delta[0];
				int nc = current[1] + delta[1];
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc]==1) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc,current[2]+1});
				}
			}
		}
		System.out.println(answer);
		
	}

	private static boolean isIn(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 1 && nr <= N && nc >= 0 && nc <= M;
	}

}

/*
 * 4 6
101111
101010
101011
111011
 */
