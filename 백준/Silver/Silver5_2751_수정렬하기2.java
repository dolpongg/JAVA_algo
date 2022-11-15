package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Silver5_2751_수정렬하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[2000001];
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine()) + 1000000;
			arr[tmp] = true;
			if(tmp > max) max = tmp;
			if(tmp < min) min = tmp;
		}
		
		for(int i = min; i <= max; i++) {
			if(arr[i]) {
				sb.append(i-1000000).append("\n");
			}
		}
		System.out.println(sb);
	}

}
