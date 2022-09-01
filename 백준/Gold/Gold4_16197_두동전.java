package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Gold4_16197_두동전 {
	static int N, M;
	static char [][] map;
	static int[][] deltas = {{0,1}, {1,0},{0,-1},{-1,0}};
	
	public static class Coin{
		int r, c;
		
		public Coin(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public boolean isOut(int r, int c){
			return r <= 0 || r >= N-1 || c <= 0 || c >= M-1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N+1][M+1];
		List<Coin> coins = new ArrayList<Coin>();
		
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
				if(map[r][c] == 'o') {
					coins.add(new Coin(r,c));
				}
			}
		}//입력완료
		
		boolean[][][][] visited = new boolean[N][M][N][M];
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {coins.get(0).r, coins.get(0).c,coins.get(1).r, coins.get(1).c, 1});
		visited[coins.get(0).r][coins.get(0).c][coins.get(1).r][coins.get(1).c] = true;
		
		int answer = 0;
		outer : while(q.size() != 0) {
			int [] current = q.poll();
			if(isOut(current[0],current[1]) && isOut(current[2],current[3])) continue;
			
			for(int [] delta : deltas) {
				int nr1 = current[0] + delta[0];
				int nc1 = current[1] + delta[1];
				int nr2 = current[2] + delta[0];
				int nc2 = current[3] + delta[1];
				if((isOut(nr1,nc1) && !isOut(nr2, nc2)) || (!isOut(nr1,nc1) && isOut(nr2, nc2)) || current[4] >= 10) {
					answer = current[4] > 9 ? -1 : current[4];
					break outer;
				}
				if(isIn(nr1,nc1) && isIn(nr2,nc2)) {
					if(map[nr1][nc1] == '#') {
						nr1 = current[0];
						nc1 = current[1];
					}
					if(map[nr2][nc2] == '#') {
						nr2 = current[0];
						nc2 = current[1];
					}
					if(!visited[nr1][nc1][nr2][nc2]) {
						q.offer(new int [] {nr1, nc1, nr2, nc2, current[4] + 1});
						visited[nr1][nc1][nr2][nc2] = true;
					}
				}
			}
			
		}
		System.out.println(answer == 0 ? -1 : answer);
		
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M; 
	}
	public static boolean isOut(int r, int c){
		return r < 0 || r > N || c < 0 || c > M;
	}

}
