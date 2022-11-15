package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_8958_OX퀴즈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n < N; n++) {
			char[] input = br.readLine().toCharArray();
			
			int total = 0;
			int sum = 0;
			for(char c:input) {
				if(c == 'X') {
					sum = 0;
				}
				else {
					sum++;
					total += sum;
				}
			}
			
			sb.append(total).append('\n');
		}
		System.out.println(sb);

	}

}
