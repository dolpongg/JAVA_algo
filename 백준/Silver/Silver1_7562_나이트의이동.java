package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_7562_나이트의이동 {
	static int I;
	static int[] TO;
	static boolean[][] visited;
	static int[][] deltas = {{-1,2}, {1,2}, {2,1},{2,-1},{1,-2}, {-1,-2}, {-2,-1}, {-2,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			I = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] input = new int[2];// 현재 있는 
			input[0] = Integer.parseInt(st.nextToken());
			input[1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			TO = new int[2];
			TO[0] = Integer.parseInt(st.nextToken());
			TO[1] = Integer.parseInt(st.nextToken());
			
			visited = new boolean[I][I];
			
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {input[0],input[1],0});
			visited[input[0]][input[1]] = true;
			int answer = 0;
			while(q.size() != 0) {
				int [] current = q.poll();
				if(current[0] == TO[0] && current[1] == TO[1]) {
					answer = current[2];
					break;
				}
				
				for(int [] delta : deltas) {
					int nr = current[0] + delta[0];
					int nc = current[1] + delta[1];
					
					if(isIn(nr,nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new int[] {nr,nc,current[2]+1});
					}
				}
			}
			System.out.println(answer);
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < I && nc >= 0 && nc < I;
	}
}

/*
3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
*/