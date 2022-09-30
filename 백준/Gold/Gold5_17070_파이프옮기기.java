package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold5_17070_파이프옮기기 {
	
	static int N;
	static int[][] map;
	static long[][][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new long [N][N][3];
		
		boolean block_r = false;
		boolean block_c = false;
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c< N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(r == 0) {
					if(map[r][c] == 1) block_r = true;
					if(!block_r) {
						dp[r][c][0] = 1;
					}
					continue;
				}
				
				
				if(r==1 && c == 2) {
					if(map[r][c-1] == 0  && map[r][c] == 0 && map[r-1][c] == 0) {
						dp[r][c][2] = 1;
					}
				}
			}
		}
		
		//입력 완료
		
		for(int r = 1; r < N; r++) {
			for(int c = 2; c < N; c++) {
				//벽
				if(map[r][c] == 1) continue;
				if(r == 1 && c == 2) continue;
				dp[r][c][0] = dp[r][c-1][0] +dp[r][c-1][2];//가로
				dp[r][c][1] = dp[r-1][c][1] + dp[r-1][c][2];//세로
				
				//대각선
				if(map[r][c-1] == 0  && map[r][c] == 0 && map[r-1][c] == 0) {
					dp[r][c][2] = dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2];
				}
				
			}
		}
		
		
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				System.out.print(Arrays.toString(dp[r][c]) + " | ");
//			}
//			System.out.println();
//		}
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}

}


/*
3
0 0 0
0 0 0
0 0 0
*/