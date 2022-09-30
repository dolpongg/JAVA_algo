package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5_1476_날짜계산 {

	static int E = 15;
	static int S = 28;
	static int M = 19;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] input = new int[3];
		for(int i = 0; i < 3; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}//입력완료
		
		int answer = 0;
		while(!((answer % E) + 1 == input[0] && (answer % S) + 1 == input[1] && (answer % M) + 1 == input[2])) {
			answer++;
		}
		
		System.out.println(answer+1);
		

	}

}
