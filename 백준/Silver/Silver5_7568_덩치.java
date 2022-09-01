package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_7568_덩치 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int [N][2];
		
		for(int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}//입력 끝
		
		for(int i = 0; i < arr.length; i++) {
			int rank = 1;
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] ) {
					rank++;
				}
			}
			System.out.println(rank);
		}
		
	}

}
