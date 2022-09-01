package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5_5014_스타트링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		boolean [] visited = new boolean[F+1];

		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {S,0});
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int [] current = q.poll();
			
			if(current[0] == G) {
				System.out.println(current[1]);
				return;
			}
			
			int nFloor = current[0]+U;
			if(nFloor < F && !visited[nFloor]) {
				visited[nFloor] = true;
				q.offer(new int[] {nFloor, current[1]+1});
			}
			nFloor = current[0] - D;
			if(nFloor >= 0 &&!visited[nFloor]) {
				visited[nFloor] = true;
				q.offer(new int[] {nFloor, current[1]+1});
			}
			
		}
		System.out.println("use the stairs");
	}

}
