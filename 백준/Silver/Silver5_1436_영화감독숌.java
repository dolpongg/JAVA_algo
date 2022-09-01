package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver5_1436_영화감독숌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 0;
		int cnt = 0;
		while(true) {
			if(Integer.toString(++num).contains("666")) {
				if(++cnt == N) break;
				
			}
		}
		System.out.println(num);
	}
}
