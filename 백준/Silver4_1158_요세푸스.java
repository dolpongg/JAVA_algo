import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * @author dolpong
 * @date 2022.08.08 
 * @url https://www.acmicpc.net/problem/1158
 * @git
 * @performance 292844	616
 * @category 
 * @note 
 */
public class Silver4_1158_요세푸스 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			que.add(i);
		}

		int index = -1;
		int flg = 0;
		while(que.size() > 1) {
			flg++;
			if(flg % K == 0) {
				sb.append(que.poll()).append(", ");
			}else {
				int tmp = que.poll();
				que.add(tmp);
			}
			
		}
		sb.append(que.poll()).append(">");
		System.out.println(sb);
	}

}
