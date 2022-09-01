package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver5_10815_숫자카드 {
	static int N,M;
	static int[] numArr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);// 이분탐색을 위한 정렬
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			bs(0, N-1, Integer.parseInt(st.nextToken()));
		}
		System.out.println(sb);
	}
	private static void bs(int start, int end, int num) {
		if(start <= end) {
			
			int mid = (end + start) / 2;
			if(numArr[mid] == num) {
				sb.append(1).append("\n");
				return;
			}
			if(numArr[mid] < num) {
				bs(mid+1, end, num);
				return;
				
			}else{
				bs(start, mid-1, num);
				return;
			}
		}
		
		sb.append(0).append("\n");
	}
}
