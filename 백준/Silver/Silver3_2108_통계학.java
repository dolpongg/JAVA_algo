package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver3_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] nums = new int[8001];
		
		int N = Integer.parseInt(br.readLine());
		long mean = 0; //산술평균 
		for(int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			nums[tmp + 4000]++;
			mean+=tmp;
		}
		mean = Math.round((double) mean / N);
		
		int midCnt = 0;
		int mid = 0;
		int max = 0; 
		int min = 0;
		int mode = 0;
		List<Integer> modeList = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]>0) {
				if(midCnt < (N+1)/2) {
					if(midCnt == 0) min = i;
					midCnt+=nums[i];
					mid = i - 4000;
				}
				max = i;
				
				if(nums[i] == nums[mode]) {
					modeList.add(i);
				}
				else if(nums[i] > nums[mode]) {
					modeList.clear();
					modeList.add(i);
					mode = i;
				}
			}
		}
				
		if(modeList.size() == 1) mode = modeList.get(0);
		else {
			Collections.sort(modeList);
			mode = modeList.get(1);
		}
		int range = max- min;

		sb.append(mean).append("\n");
		sb.append(mid).append("\n");
		sb.append(mode-4000).append("\n");
		sb.append(range);
		
		System.out.println(sb);
		
	}
}
