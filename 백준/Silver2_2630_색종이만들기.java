import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author dolpong
 * @date 2022.08.21
 * @url https://www.acmicpc.net/problem/2630
 * @git 
 * @performance 
 * @category 분할 정
 * @note 
 */
public class Silver2_2630_색종이만들기 {
	static int[][] map;
	static int[] answer=  {0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int r = 0; r < n; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dc(0,0,n);
		
		for(int a : answer) {
			System.out.println(a);
		}
	}
	private static void dc(int r, int c, int n) {
		int first = map[r][c];
		
		for(int nr = r; nr < r+n; nr++) {
			for(int nc = c; nc < c+n; nc++) {
				if(first != map[nr][nc]) {
					dc(r,c,n/2);
					dc(r,c+n/2,n/2);
					dc(r+n/2,c,n/2);
					dc(r+n/2,c+n/2,n/2);
					return;
				}
			}
		}
		answer[first]++;
		
		return;
		
	}
}
