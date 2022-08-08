package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 한빈이와_Spot_Mart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(list, Collections.reverseOrder()); // 큰 순으로 정렬
			int max = 0;
			for(int i = 0; i < N; i++) {
				if(list.get(i) >= M) {
					continue;
				}
				for(int j = i+1; j < N-1; j++) {
					int sum = list.get(i) + list.get(j);
					if(sum > M) continue;
					if(max < sum) {
						max = sum;
					}
				}
			}
			if(max == 0) {
				max = -1;
			}
			
			sb.append(max);
			System.out.println(sb);
			
		}

	}

}
