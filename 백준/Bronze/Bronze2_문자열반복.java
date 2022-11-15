package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze2_문자열반복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int repeat = Integer.parseInt(st.nextToken());
			char[] input = st.nextToken().toCharArray();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < input.length; i++) {
				for(int c = 0; c < repeat; c++) {
					sb.append(input[i]);
				}
			}
			System.out.println(sb);
			
		}

	}

}
