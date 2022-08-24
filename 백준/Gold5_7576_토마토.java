import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_7576_토마토 {
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int R,C;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		
		boolean flag = false;
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 0) flag = true;
				if(map[r][c] == 1) {
					q.offer(new int[] {r,c});
				}
			}
		}//입력 완료
		
		if(!flag) { // 만약 토마토 처음부터 다 익어있으면 0 출력
			System.out.println(0);
			return;
		}
		
		int depth = -1;
		boolean[][] visited = new boolean[R][C];
		while(!q.isEmpty()) {
			int size = q.size();
			depth++;
			
			while(size -- > 0) {
				int [] current = q.poll();
				
				map[current[0]][current[1]] = 1;
				
				for(int[] delta : deltas) {
					int nr = current[0] + delta[0];
					int nc = current[1] + delta[1];
					
					if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == 0) { // 맵 안 + 방문한 적 없고 + 토마토 안익은 곳
						q.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
					
				}
			}
		}
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(depth);
		
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}

/*
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
*/