package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold4_3055_탈출 {
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static int R,C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int[] start = new int [2];//고슴도치
		int[] end = new int[2];//땅굴
		List<int[]> water = new ArrayList<>();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char [][] map = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'S') {
					start[0] = r;
					start[1] = c;
				}
				if(map[r][c] == 'D') {
					end[0] = r;
					end[1] = c;
				}
				if(map[r][c] == '*') {
					water.add(new int[] {r,c});
				}
			}
		} // 입력 완료
		
		
		Queue<int[]> q = new LinkedList<int[]>();
//		Queue<int[]>wq = new LinkedList<int[]>();
		for(int i = 0; i < water.size() ;i++) {
			q.offer(water.get(i));
		}
		q.add(new int[] {start[0], start[1], 0});
		
		while(!q.isEmpty()) {
			//물이 먼저 방문처리
			int size = q.size();
			while(size -- > 0) {
				int[] current = q.poll();
				if(current.length == 2) {
					for(int[] delta : deltas) {//미리 방문 처리
						int nr = current[0] + delta[0];
						int nc = current[1] + delta[1];
						if(isIn(nr,nc) &&map[nr][nc] == '.' && map[nr][nc] != 'D' && map[nr][nc]!= 'X') {//물은 비버에 닿으면 안돼
							q.offer(new int [] {nr,nc});
							map[nr][nc] = '*';
						}
						
					}
				}
				else {
					if(current[0] == end[0] && current[1] == end[1]) {
						System.out.println(current[2]);
						return;
					}
					
					for(int [] delta : deltas) {
						int nr = current[0] + delta[0];
						int nc = current[1] + delta[1];
						if(isIn(nr,nc) && (map[nr][nc] == '.' || map[nr][nc] == 'D')) {// 도치는 물에 닿으면 안돼
							map[nr][nc] = 'S';
							q.offer(new int[] {nr,nc,current[2]+1});
						}
					}
				}
			}
			
		}
		System.out.println("KAKTUS");
		
	}

	private static boolean isIn(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}

/*
3 3
D.*
...
.S.
*/