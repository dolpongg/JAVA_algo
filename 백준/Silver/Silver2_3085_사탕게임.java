package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver2_3085_사탕게임 {
	
	static int N;
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int answer = 0;
		//1. 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		
		
		//2. 노드 하나
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				//오른쪽 바꾸기
				if(c+1 < N) {
					char tmp = map[r][c];
					map[r][c] = map[r][c+1];
					map[r][c+1] = tmp;
					
					//가장 긴 노드 탐색
					answer = Math.max(answer, search(new int[][] {{r,c}, {r,c+1}}, false));
					
					tmp = map[r][c];
					map[r][c] = map[r][c+1];
					map[r][c+1] = tmp;
				}
				//아쪽 바꾸기
				if(r+1 < N) {
					char tmp = map[r][c];
					map[r][c] = map[r+1][c];
					map[r+1][c] = tmp;
					
					//가장 긴 노드 탐색
					answer =  Math.max(answer, search(new int[][] {{r,c}, {r+1,c}}, true));
					
					tmp = map[r][c];
					map[r][c] = map[r+1][c];
					map[r+1][c] = tmp;
				}
				
				
			}
		}
		//3. 정답 출
		System.out.println(answer);
		
	}
	private static int search(int[][] changes, boolean right) {
		int max = 0;
		if(right) {
			for(int[] ch : changes) {
				int cnt = 1;
				for(int r = 0; r< N-1; r++) {
					if(map[r][ch[1]] == map[r+1][ch[1]]) cnt++;
					else {
						max = Math.max(max, cnt);
						cnt = 1;
					}
				}
				max = Math.max(max, cnt);
			}
			int cnt = 1;
			for(int c = 0; c < N-1; c++) {
				if(map[changes[0][0]][c] == map[changes[0][0]][c]) cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}else {
			for(int[] ch : changes) {
				int cnt = 1;
				for(int c = 0; c< N-1; c++) {
					if(map[ch[0]][c] == map[ch[0]][c+1]) cnt++;
					else {
						max = Math.max(max, cnt);
						cnt = 1;
					}
				}
				max = Math.max(max, cnt);
			}
			int cnt = 1;
			for(int r = 0; r < N-1; r++) {
				if(map[r][changes[0][1]] == map[r+1][changes[0][1]]) cnt++;
				else {
					max = Math.max(max, cnt);
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}
		
		return max;
	}
}
