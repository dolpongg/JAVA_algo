package Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Silver5_4673_셀프넘버 {
	public static void main(String[] args) {
		boolean[] check = new boolean[10001];
		for(int num = 1; num <= 10000; num++) {
			int sum = num;
			String tmp = Integer.toString(num);
			for(int i = 0; i < tmp.length(); i++) {
				sum += tmp.charAt(i) - '0';
			}
			if(sum > 10000) continue;
			check[sum] = true;
		}
		
		for(int i = 1; i <= 10000; i++) {
			if(!check[i])System.out.println(i);
		}
	}
}
