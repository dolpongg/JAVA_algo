package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Silver4_10816_숫자카드2 {
	static int N,M;
	static int[] numArr;
	static HashMap<Integer, Integer> hs = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!hs.containsKey(num)) hs.put(num, 1);
			else hs.put(num,hs.get(num) + 1);
		}
		
		int idx = 0;
		numArr = new int[hs.size()];
		for(int i : hs.keySet()) {
			numArr[idx] = i;
			idx++;
		}
		Arrays.sort(numArr);
		
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			bs(0, numArr.length-1, Integer.parseInt(st.nextToken()));
		}
		System.out.println(sb);
	}

	private static void bs(int start, int end, int num) {
		if(start <= end) {
			int mid = (start + end) / 2;
			
			if(numArr[mid] == num) {
				sb.append(hs.get(num)).append(" ");
				return;
			}
			if(num > numArr[mid]) {
				bs(mid+1, end, num);
				return;
			}else {
				bs(start, mid-1, num);
				return;
			}
		}
		sb.append(0).append(" ");
		
	}
}
