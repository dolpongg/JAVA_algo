import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold3_16236_아기상어 {
	static int N;
	static int[][] map;
	static int[][] deltas = {{-1,0},{0,-1},{1,0},{0,1}};
	static Shark baby = null;
	
	
	static public class Shark{
		int r,c,s;
		public Shark(int r, int c, int s) {
			this.r =r;
			this.c = c;
			this.s = s;
		}
	}
	
	static public class Fish implements Comparable<Fish>{
		int r, c, s;

		public Fish(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.r == o.r) {
				return Integer.compare(this.c, o.c);
			}
			return Integer.compare(this.r, o.r);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		Shark baby = null;
		
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c <N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					baby = new Shark(r,c,2);
					map[r][c] = 0;
				}
			}
		}//입력 완료
		
		bfs();
	}


	private static void bfs() {
		Queue<Shark> q = new LinkedList<>();
		int depth = 0;
		q.offer(baby); // 상어 현재 위치
		
		boolean[][] visited = new boolean[N][N];
		while(q.isEmpty()) {
			int size = q.size();
			
			Fish target = null;
			while(size -- > 0) {
				Shark current = baby;
				if(map[current.r][current.c] < baby.s) {
					if(target == null) {
						target = new Fish(current.r, current.c, map[current.r][current.c]);
					}else {
						Fish tmp = new Fish(current.r, current.c, map[current.r][current.c]);
						target = target.compareTo(tmp) > 0 ? target : tmp;
					}
				}
				
				for(int [] delta : deltas) {
					int nr = current.r + delta[0];
					int nc = current.c + delta[1];
					
					if(isIn(nr,nc) && visited[nr][nc] &&current.s >= map[nr][nc]) {
						q.offer(new Shark(nr,nc,current.s));
					}
				}
				
				
			}
			if()
			depth++;
		}
		
	}


	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc <N;
	}
}

/*
3
0 0 0
0 0 0
0 9 0
*/