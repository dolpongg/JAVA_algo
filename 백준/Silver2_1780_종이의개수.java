import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @author dolpong
 * @date 2022.08.21
 * @url https://www.acmicpc.net/problem/1780
 * @git 
 * @performance 317560	792
 * @category 분할정
 * @note 
 */

public class Silver2_1780_종이의개수 {
	static int[][] map;
	static int[] answer = {0,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dc(0,0,N);
		for(int a : answer) {
			System.out.println(a);
		}
	}

	private static void dc(int r, int c, int size) {
		if(!checkNum(r,c,size)) {
			for(int nr = r; nr < r+size; nr+=size/3) {
				for(int nc = c; nc < c+size; nc += size/3) {
					dc(nr,nc,size/3);
				}
			}
			
		}else answer[map[r][c]+1]++;
		
		return;
		
	}

	private static boolean checkNum(int r, int c, int size) {
		int first = map[r][c];
		
		for(int nr = r; nr< r+size; nr++) {
			for(int nc = c; nc< c+size; nc++) {
				if(first != map[nr][nc]) return false;
			}
		}
		
		return true;
	}

}
/*
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1
*/