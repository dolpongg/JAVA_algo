import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		char[] input = br.readLine().toCharArray();
		int[] answer = new int[26];
		Arrays.fill(answer, -1);
		
		for(int c = 0; c < input.length; c++) {
			answer[(int)input[c] - 'a'] = c;
		}
		for(int i : answer) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb);
		
	}
}