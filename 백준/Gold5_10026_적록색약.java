import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold5_10026_적록색약 {
	static int N;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		char[][] mapRB = new char[N][N];
		for(int r = 0; r< N; r++) {
			String line = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'G') mapRB[r][c] = 'R';
				else mapRB[r][c] = line.charAt(c);
			}
		}//입력 완료
		
		
		boolean[][] visited = new boolean[N][N];
		int count1 = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer(new int[] {r,c});
					
					while(!q.isEmpty()) {
						int[] current = q.poll();
						
						for(int [] delta : deltas) {
							int nr = current[0] + delta[0];
							int nc = current[1] + delta[1];
							
							if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc] == map[current[0]][current[1]]) {
								visited[nr][nc] = true;
								q.offer(new int[] {nr,nc});
							}
						}
					}
					count1++;
				}
			}
		}
		visited = new boolean[N][N];
		int count2 = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visited[r][c]) {
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer(new int[] {r,c});
					
					while(!q.isEmpty()) {
						int[] current = q.poll();
						
						for(int [] delta : deltas) {
							int nr = current[0] + delta[0];
							int nc = current[1] + delta[1];
							
							if(isIn(nr,nc) && !visited[nr][nc] && mapRB[nr][nc] == mapRB[current[0]][current[1]]) {
								visited[nr][nc] = true;
								q.offer(new int[] {nr,nc});
							}
						}
					}
					count2++;
				}
			}
		}
		System.out.printf(count1 + " " + count2);
		
	}

	private static boolean isIn(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
