package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver5_2941_크로아티아알파벳 {
	static String[] cros = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int answer = 0;
		for(String cro : cros) {
			int count = 0;
			int index = 0;
			while(input.indexOf(cro, index) != -1) {
				index = input.indexOf(cro, index)+1;
				count++;
			}
			input = input.replace(cro, " ");
			answer += count;
		}
		input = input.replace(" ", "");
		answer += input.length();
		System.out.println(answer);
	}
}
