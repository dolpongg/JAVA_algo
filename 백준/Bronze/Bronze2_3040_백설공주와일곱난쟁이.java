package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author dolpong
 * @date 2022.08.14
 * @url https://www.acmicpc.net/problem/3040
 * @git 
 * @performance 11524	76
 * @category 조합 
 * @note 중간에 더 탐색할 필요없으면 바로 중단
 */
public class Bronze2_3040_백설공주와일곱난쟁이 {
	static int [] nums = new int[9];
	static int total=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new StringReader(src));
		StringBuilder sb = new StringBuilder();
		
		
		
		for(int i = 0; i < 9; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			total += nums[i];
		}//입력 완료 
		
		makeCombi(0,0, new int [2]);
		
	}
	
	public static boolean makeCombi(int nth, int startIdx, int[] choosed) {
		if(nth == choosed.length) {
			// 합이 100인지 확인하고
			//맞으면 리턴
			int sum = 0;
			for(int i :choosed) {
				sum += i;
			}
			if(total - sum == 100) {
				for(int i:nums) {
					if(i != choosed[0] && i != choosed[1]) {
						System.out.println(i);
					}
				}
				return true;
			}
			return false;
		}
		
		for(int i = startIdx; i < nums.length; i++) {
			choosed[nth] = nums[i];
			boolean flag = makeCombi(nth+1, i+1, choosed);
			if(choosed.length == nth-1 && flag) {
				return flag;
			}
		}
		
		return false;
	}

}
