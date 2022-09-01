package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_15666_N과M12 {
	static int[] nums = new int[10001];
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
			nums[num]++;
			if(start > num) start = num;
			if(end < num) end = num;
		}//입력 완료 
		
		input = new int[N];
		int index = 0;
		for(int i = start; i <= end; i++) {
			while(nums[i] > 0) {
				input[index++] = i;
				nums[i]--;
			}
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
		int before = -1;
		for(int i = start; i < N ; i++) {
			if(before != input[i]) {
				before = input[i];
				choosed[nth] = input[i];
				com(nth+1, choosed, i);
			}

		}
		
	}

}
