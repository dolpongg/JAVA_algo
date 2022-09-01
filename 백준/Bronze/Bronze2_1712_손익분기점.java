package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Bronze2_1712_손익분기점 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		if(((long)A+B) > C && (C-B) <= 0) { // 손익분기점 절대 못넘기는 경우 : 노트북 가격이 인건비보다 작음)
			System.out.println(-1);
			return;
		}
		
		int gap = C-B;
		System.out.println(A/gap + 1);
		
	}
}

/*
메모 : 변수 자료형 int끼리 더한다고 결과도 int인 법 없다~~!

전략
1. 입력 범위를 보니, 단순 반복문으로 풀면 시간초과가 날 수도 있겠다 싶었다.
최대 20억 번을 돌아야하니 말이다..!
A : 20억, C-B : 1이면 21억번 돌아야한다.

2. 그래서 고정된 값을 노트북 1개 당 순 이익(노트북 가격 - 인건비)으로 계산 했을 때 몇 개를 팔아야 메울 수 있는지의 관점에서 접근했다.

3. 그게 23번 식이다.
*/
