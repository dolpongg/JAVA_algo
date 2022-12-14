package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_15657_N과M8 {
	static boolean[] nums = new boolean[10001];
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int start = 10000;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			nums[num] = true;
			if(start > num) start = num;
			if(end < num) end = num;
		}//입력 완료 
		
		input = new int[N];
		int index = 0;
		for(int i = start; i <= end; i++) {
			if(nums[i]) input[index++] = i; 
		}
		
		com(0,new int[M], 0);
		System.out.println(sb);
	}

	private static void com(int nth, int[] choosed, int start) {
		if(nth == choosed.length) {
			for(int i : choosed) {
				sb.append(i).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i = start; i < N ; i++) {
			choosed[nth] = input[i];
			com(nth+1, choosed, i);

		}
		
	}

}
