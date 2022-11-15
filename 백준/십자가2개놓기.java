import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 십자가2개놓기 {
	
	static int R, C;
	static char[][] map;
	static int answer = 0;
	static int[][] deltas = {{1,0}, {0,-1}, {-1, 0}, {0,1}};
	
	static class Point{
		
		int r; 
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == '#') {
					find(new Point(r,c));
				}
			}
		}
		
		System.out.println(answer);
	}

	private static void find(Point point) {
		int width = 0;
		char[][] cloneMap = new char[R][C];
		
		for(int r = 0; r< R; r++) {
			System.arraycopy(map[r], 0, cloneMap[r], 0, C);
		}
		
		outer : while(true) {
//			System.out.println(point);
			

//			System.out.println("======================");
			//십자가 놓을 수 있나요?
			for(int[] delta : deltas) {
				int nr = point.r + delta[0]*width;
				int nc = point.c + delta[1]*width;
//				System.out.println(nr + " : " + nc);
				if(!isIn(nr,nc) || cloneMap[nr][nc] != '#') {
					break outer;
				}
//				cloneMap[nr][nc] = 'x'; // 십자가 표
			}
			
			
			for(int[] delta : deltas) {
				int nr = point.r + delta[0]*width;
				int nc = point.c + delta[1]*width;
				
				cloneMap[nr][nc] = 'x'; // 십자가 표시 

			}
			//십자가 하나 완성
//			for(int r = 0; r < R; r++) {
//				System.out.println(Arrays.toString(cloneMap[r]));
//				
//			}
			
			//두번째 십자가 하나 놓자
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					int secondWidth = 0;
					outer2 : while(true) {
						for(int[] delta : deltas) {
							int nr = r + delta[0]*secondWidth;
							int nc = c + delta[1]*secondWidth;
							if(!isIn(nr,nc) || cloneMap[nr][nc] != '#') {
								break outer2;
							}
						}                                                            
						secondWidth++;
						
					}
					//최대 곱 구하기
//					if(point.r == 1 && point.c == 1) {
//						System.out.println(r + " : " + c + " "+secondWidth);
//					}
					
					answer = Math.max(answer, (1 + 4*width)*(1 + 4* --secondWidth));
					
				}
			}
			
			
			width++;
			
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
