package CT.line;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class test3 {

	static int[][] map = null;
	static int [][] deltas = {{-1, 0},{1, 0},{0, -1},{0,1}};
	static int N;
	public class Totem{
		int r, c,n;
		char type;
		int[][] eff;

		public Totem(int r, int c, char type, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
			this.type = type;
			eff = new int[n][n];
		}
		
		public void spread(int m) {
			if(this.type == 'f') {
				eff[r][c]++;
				map[r][c]++;
				for(int mm= 1; mm <= m; mm++) {
					for(int nr = r-mm; nr <= r+mm ;nr++) {
						 if(isIn(nr, c-mm)) map[nr][c-mm]++;
					}
					for(int nr = r-mm; nr <= r+mm ;nr++) {
						if(isIn(nr, c+mm)) map[nr][c+mm]++;
					}
					
					for(int nc  = c-mm; nc <= c+mm; nc++) {
						if(isIn(r+mm, nc)) map[r+mm][nc]++;
					}
					for(int nc  = c-mm; nc <= c+mm; nc++) {
						if(isIn(r+mm, nc)) map[r-mm][nc]++;
					}
					
				}
				
			}
			else {
				// 준비물
		        Queue<int[]> q = new LinkedList<>();
		        boolean[][] visited = new boolean[n][n];
		        // 초기화
		        q.offer(new int[] {r,c});
		        visited[r][c] = true;
		        
		        // bfs 탐색의 depth
		        int depth = 1;
		        while(!q.isEmpty()) {
		            
		            int size = q.size();
		            
		            while(size-->0) {
		                int[] head = q.poll();
		                for(int d=0; d<deltas.length; d++)   {
		                    int nr = head[0] + deltas[d][0];
		                    int nc = head[1] + deltas[d][1];
		                    if(isIn(nr, nc) && !visited[nr][nc]) {
		                    	map[nr][nc]--;
		                        visited[nr][nc]=true;
		                        q.offer(new int[] {nr,nc});
		                        }
		                        
		                    }
		                }
		            }          
		       depth++;   
		       if(depth > m) q.clear();
		        
				
				
			}
		}

		private boolean isIn(int nr, int nc) {
			// TODO Auto-generated method stub
			 return 0<=r && r<n && 0<=c && c<N;
		}
		
	}
	
	

}
