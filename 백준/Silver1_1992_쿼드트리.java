import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_1992_쿼드트리 {	
	static StringBuilder sb = new StringBuilder();
	static int [][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}
//		sb.append("(");
		dc(0,0,N);
//		sb.append(")");
		
		System.out.println(sb);

	}

	private static void dc(int r, int c, int size) {
		
		if(!checkNum(r,c,size)) {
			int nSize = size/2;
			sb.append("(");
			dc(r,c,nSize);
			dc(r,c+nSize, nSize);
			dc(r+nSize,c, nSize);
			dc(r+nSize,c+nSize, nSize);
			sb.append(")");
		}else sb.append(map[r][c]);
		return;
	}

	private static boolean checkNum(int r, int c, int size) {
		int first = map[r][c];
		
		for(int nr = r; nr < r+size; nr++) {
			for(int nc = c; nc < c + size; nc++) {
				if(first != map[nr][nc]) return false;
			}
		}
		return true;
	}

}
/*
 * 8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011
 * */
