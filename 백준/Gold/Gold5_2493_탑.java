package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



/**
 * @author dolpong
 * @date 22.08.05
 * @url https://www.acmicpc.net/problem/2493
 * @git
 * @performance 111660	696
 * @category #스택
 * @note #StringBuilder가 그냥 출력했을 때보다 빠르다.
 */


public class Gold5_2493_탑 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] top = new int[N+1];
		for(int i = 1; i <= N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}
		//--입력 끝
		
		
		for(int i = 1; i <= N; i++) {//맨 앞의 탑부터 하나씩 비교하는데
			for(int j = i; j >= 0; j--) {// 지금까지 쌓은 스택의 윗쪽부터 확인
				if(!stack.empty()) {//스택이 비어있지 않으면 = 아직 비교해볼 게 남아있으면
					if(stack.peek()[1] >= top[i]) { // 스택의 가장 윗부분이 현재 탑보다 높거나 같은지 확인하고
						sb.append(stack.peek()[0]).append(' '); // 거기에 신호가 닿음. 출력 추가
						break;// 이 탑은 끝! 다음 탑으로
					}
					//스택 윗부분이 현재 탑보다 낮으면 이거 꺼내고 버림(=더 이전 탑과 비교하기 위함)
					stack.pop();
					
				}else {//스택 비어있으면 = 비교할 게 없으면 => 닿는 탑이 없음
					sb.append("0 ");
					break;
				}
			}
			stack.push(new int[] {i, top[i]}); // 스택 추가
		}
		
		System.out.println(sb);
	}

}