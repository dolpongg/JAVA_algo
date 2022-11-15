package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze1_2309_일곱난쟁이 {
	static int[] nums = new int[9];
	static int[] result = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
//		System.out.println(Arrays.toString(nums));

		makeCombination(0, new int[7], 0);
//		System.out.println(result);
		Arrays.sort(result);
		
		for (int i : result) {
			sb.append(i).append("\n");
		}

		System.out.println(sb);
	}

	static void makeCombination(int nth, int[] choosed, int startIdx) {
		if (result != null)
			return;
		if (nth == choosed.length) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += choosed[i];
			}
//			System.out.println(Arrays.toString(choosed));
			if (sum == 100) {
//				System.out.println(1);
				result = Arrays.copyOf(choosed, 7);
			}
			return;
		}
//		System.out.println(nums.length);
		for (int i = startIdx; i < nums.length; i++) {
			choosed[nth] = nums[i];
//			System.out.println(nums[i]);
			makeCombination(nth + 1, choosed, i + 1);

		}

	}
}
