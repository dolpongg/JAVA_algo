import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author dolpong
 * @date 22.08.05
 * @url https://www.acmicpc.net/problem/12891
 * @git
 * @performance 20516	188
 * @category #슬라이딩_윈도우
 * @note 
 */

public class Silver2_12891_DNA_비밀번호 {
	
	static int [] CHAR_CNT = new int['Z'+1];
	static int[] dna = new int[4];//dna 문자 제한 
	
	public static void main(String[] args) throws IOException {
		/*
		 * 1. 1,000,000은 시간 복잡도 O(NlogN)로 만들어야함 (N^2 절대 불가)
		 * 2. 중복하는 건 제외하고 빠지고, 새로운 것에 대해서만 연산 : 슬라이딩 윈도우 => O(N)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 서브문자열 길이
		
		String line  = br.readLine();
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			dna[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		for (int p = 0; p < P; p++) {
			CHAR_CNT[line.charAt(p)]++;
		}
		if(isPossible()) {
			answer++;
		}
		for (int i = 0; i < S - P; i++) {
			CHAR_CNT[line.charAt(i)]--;
			CHAR_CNT[line.charAt(i+P)]++;
			if(isPossible()) {
				answer++;
			}
		}
		System.out.println(answer);

	}
	
	static boolean isPossible() {
		return CHAR_CNT['A'] >= dna[0] && CHAR_CNT['C'] >= dna[1] && CHAR_CNT['G'] >= dna[2] && CHAR_CNT['T'] >= dna[3];
	}

}
