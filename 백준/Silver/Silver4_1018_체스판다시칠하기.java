package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver4_1018_체스판다시칠하기 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char [][] arr =new char[N][M];
		
		
		for(int r = 0; r < N; r++) {
			String line = br.readLine();

			for(int c = 0; c < M; c++) { // 초기
				arr[r][c] = line.charAt(c);
			}
			
		}

		
		int answer = Integer.MAX_VALUE;
		
		for(int r = 0; r < N-8+1; r++) {
			for(int c = 0; c < M - 8+1; c++) {
				int sumBW = 0;
				for(int nr = 0; nr < 8; nr++) {
					for(int nc = 0 ; nc < 8; nc++) {
						if((r+nr+c+nc) % 2 == 0) {
							if(arr[r+nr][c+nc] != 'B') {
								sumBW++;
							}
						}else {
							if(arr[r+nr][c+nc] != 'W') {
								sumBW++;
							}
						}
				
					}
				}
				if(sumBW > 32) {
					answer = answer >(64-sumBW) ? 64 - sumBW : answer;
				}else {
					answer = answer >sumBW ? sumBW : answer;
					
				}
				
			}
		}
		
		
		sb.append(answer);
		System.out.println(answer);
		
	}

}
