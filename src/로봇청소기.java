import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {
	static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int N,M;
	static int[][] map;
	static int answer = 0;
	
	static class Cleaner{
		
		int r;
		int c;
		int d;
		
		Cleaner(int r, int c, int d){
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());
		
		Cleaner start = new Cleaner(sr, sc, sd);
		
		map = new int[N][M];
		for(int r = 0; r < N; r++)
		{
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(start);
		
		System.out.println(answer);
	}


	private static void bfs(Cleaner start) {
		Queue<Cleaner> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		visited[start.r][start.c] = true;
		map[start.r][start.c] = 2;
		answer++;
		q.offer(start);
		
		outer : while(!q.isEmpty()) {
			Cleaner cur = q.poll();			
			
			for(int i = 1; i <= 4; i++) {
				int index = cur.d - i;
				if(index < 0) index = 4+index;
				
				int nr = cur.r + deltas[index][0];
				int nc = cur.c + deltas[index][1];
				
				if(isIn(nr,nc)) {
					if(map[nr][nc] == 0) {
						map[nr][nc] = 2;
						answer++;
						q.offer(new Cleaner(nr,nc,index));
						continue outer;
					}
				}
			}
			
			if(map[cur.r - deltas[cur.d][0]][cur.c - deltas[cur.d][1]]!=1) {
				q.offer(new Cleaner(cur.r - deltas[cur.d][0], cur.c - deltas[cur.d][1], cur.d));
			}
		}
		
	}


	private static boolean isIn(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
