package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver4_1065_한수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		outer : for(int num = 1; num <= N; num++) {
			String tmp = Integer.toString(num);
			int gap = 0;
			for(int i = 0; i < tmp.length()-1; i++) {
				if(i == 0) {
					gap = (tmp.charAt(i) - '0') - tmp.charAt(i+1) - '0';
					continue;
				}
				if(gap != (tmp.charAt(i) - '0') - tmp.charAt(i+1) - '0') {
					continue outer;
				}
			}
			
			answer++;
		}
		System.out.println(answer);
	}
}
