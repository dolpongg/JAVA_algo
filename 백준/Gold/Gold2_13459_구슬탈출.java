package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2_13459_구슬탈출 {
	static int R,C;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static char[][] map;
	
	static class Marble{
		int r, c;
		boolean isRed;
		public Marble(int r, int c, boolean isRed) {
			this.r = r;
			this.c = c;
			this.isRed = isRed;
		}
		
		void go(int d) {
			int i = 1;
			while(true) {
				int nr = r + deltas[d][0] * i;
				int nc = c + deltas[d][1] * i;
				//구멍있으면바로 리턴
				if(map[nr][nc] == 'O') {
					this.r = nr;
					this.c = nc;
					return;
				}
				else if(map[nr][nc] == '#') {// 벽이면 벽 전 좌표로 리턴 	
					this.r = nr - deltas[d][0];
					this.c = nc - deltas[d][1];
					map[this.r][this.c]='#';
					return;
				}
				i++;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		Marble red = null;
		Marble blue = null;
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 'R') red = new Marble(r,c,true);
				if(map[r][c] == 'B') blue = new Marble(r,c,false);
			}
		}
		
		bfs(red,blue);
		
		
	}
	
	static void bfs(Marble red, Marble blue) {
		Queue<Marble[]> q = new LinkedList<>();
		boolean [][][][] visited = new boolean[R][C][R][C];
		
		q.offer(new Marble[] {red, blue});
		visited[red.r][red.c][blue.r][blue.c] = true;
		
		int depth = 1;
		while(!q.isEmpty()) {
			if(depth > 10) break;
			int size = q.size();
			while(size-->0) {
//				System.out.println(size);
				Marble[] cur = q.poll();
				
				for(int d = 0; d < deltas.length; d++) {
//					System.out.println(d);
					Marble M1 = new Marble(cur[0].r, cur[0].c, cur[0].isRed);
					Marble M2 = new Marble(cur[1].r, cur[1].c, cur[1].isRed);
					
					if(d==0) {//r작은 애가 먼저 
						if(M1.r > M2.r) {
							M2.go(d);
							M1.go(d);
							
						}else {
							M1.go(d);
							M2.go(d);
						}
						
					}else if(d == 1) {//r큰애가 먼저 
						if(M1.r < M2.r) {
							M2.go(d);
							M1.go(d);
						}else {
							M1.go(d);
							M2.go(d);
						}
					}else if(d==2) {//c작은 애가 먼저 
						if(M1.c > M2.c) {
							M2.go(d);
							M1.go(d);
						}else {
							M1.go(d);
							M2.go(d);
						}
					}else {
						if(M1.c < M2.c) {
							M2.go(d);
							M1.go(d);
						}else {
							M1.go(d);
							M2.go(d);
						}
					}
					
					if(map[M1.r][M1.c] == '#') map[M1.r][M1.c] = '.';
					if(map[M2.r][M2.c] == '#') map[M2.r][M2.c] = '.';
					
					
					//빨간공 무엇
					Marble nR = M1.isRed ? M1 : M2;
					Marble nB = !M1.isRed ? M1 : M2;
					
					if(map[nB.r][nB.c] == 'O') continue;
					else if(map[nR.r][nR.c] == 'O') {
						System.out.println(1);
						return;
					}else {
						if(!visited[nR.r][nR.c][nB.r][nB.c]) {
							visited[nR.r][nR.c][nB.r][nB.c] = true;
							q.offer(new Marble[] {nR, nB});
						}
					}
				}
			}
			depth++;
		}
		System.out.println(0);
		return;

	}
}
