package Bronze;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author dolpong
 * @date 2022.08.14
 * @url 
 * @git 
 * @performance 
 * @category 
 * @note 
 */

public class Bronze2_2231_부분합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int nCount = Integer.toString(N).length();
		
		
		int answer = Integer.MAX_VALUE;
		for(int i = N; i > N - (nCount*9); i--) {
			int sum = i;
			int num = i;
			
			for(int j = 1_000_000; j >= 10; j /=10) {
				sum += num / j;
				num %= j;
			}
			sum += num;
			
			if(sum == N) {
				answer = Math.min(answer, i);
			}
			
		}
		if(answer == Integer.MAX_VALUE) {
			sb.append(0);
		}else {
			sb.append(answer);
		}
		
		System.out.println(sb);
	}

}
