package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4_4485_녹색옷입은애가젤다지 {
	static int N;
	static int[][] map;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int p = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)break;
			p++;
			
			map = new int[N][N];
			
			for(int r = 0; r< N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Point> pq = new PriorityQueue<>(); //1. 우선순위 큐 생성 
			
			int[][] minDis = new int[N][N];// 2. 최소 거리 배열
			
			for(int r = 0; r < N; r++) { //3. 최소 거리 배열 초기화
				Arrays.fill(minDis[r], Integer.MAX_VALUE);
			}
			
			pq.offer(new Point(0,0,map[0][0])); // 4.출발 기준 노드 인큐
			minDis[0][0] = 0;
			
			while(!pq.isEmpty()) {// 5. 큐 빌 때까지 반복 
				//5-1. 대장 나와
				Point current = pq.poll();
				
				//5-2. 방문 처리
				if(current.r == N-1 && current.c == N-1) {
					sb.append("Problem ").append(p).append(": ").append(current.w).append("\n");
					break;
				}
				
				for(int[] delta : deltas) { // 5-3. 자식 노드 방문 
					int nr = current.r + delta[0];
					int nc = current.c + delta[1];
					
					if(isIn(nr,nc) && current.w + map[nr][nc] < minDis[nr][nc]) {
						minDis[nr][nc] = current.w + map[nr][nc];
						pq.offer(new Point(nr,nc,minDis[nr][nc]));
					}
				}
			}
			
		}
		System.out.println(sb);
	}
	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >=0 && nc < N;
	}
	public static class Point implements Comparable<Point>{
		int r,c,w;
		
		public Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		@Override
		public int compareTo(Gold4_4485_녹색옷입은애가젤다지.Point o) {
			return Integer.compare(this.w, o.w);
		}
		
		
	}
}
/*
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0
*/