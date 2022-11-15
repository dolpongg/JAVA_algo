import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			int C = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][C];
			
			for(int r = 0; r < 2; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < C; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			//입력 완료 
			
			int[][] dp = new int[2][C];
			//초기화 
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if(C == 1) {
				sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
				continue;
			}
			dp[0][1] = dp[1][0] + arr[0][1];
			dp[1][1] = dp[0][0] + arr[1][1];
			
			for(int c = 2; c < C; c++) {
				int max = 0; 
				max = Math.max(dp[1][c-1], dp[1][c-2]);
				dp[0][c] = max+ arr[0][c];
				
				max =  Math.max(dp[0][c-1], dp[0][c-2]);
				dp[1][c] = max+ arr[1][c];
			}
			
			sb.append(Math.max(dp[1][C-1], dp[0][C-1])).append("\n");
		}
		System.out.print(sb);
	}
}
