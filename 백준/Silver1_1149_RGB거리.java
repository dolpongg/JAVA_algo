
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author dolpong
@since 2022. 8. 26.
@see
@git
@youtube
@performance
@category #
@note */
public class Silver1_1149_RGB거리{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N;
	static int[][] RGB;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		RGB = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 3; c++) {
				int cost= Integer.parseInt(st.nextToken());
				if(r == 0) {
					dp[r][c] = cost;
				}
				else {
					switch (c) {
					case 0: {
						dp[r][c] = Math.min(dp[r-1][1], dp[r-1][2]) + cost;break;
					}
					case 1: {
						dp[r][c] = Math.min(dp[r-1][0], dp[r-1][2]) + cost;break;
					}
					case 2: {
						dp[r][c] = Math.min(dp[r-1][0], dp[r-1][1]) + cost;break;
					}
				}
			}
		}
	}
		Arrays.sort(dp[N-1]);
		System.out.println(dp[N-1][0]);
	}
	
}

//3
//26 40 83
//49 60 57
//13 89 99
