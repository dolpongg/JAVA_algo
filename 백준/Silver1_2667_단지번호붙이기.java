import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_2667_단지번호붙이기 {
	
	static int [][] map;
	static boolean [][] visited;
	static int N;
	static int[][] deltas = {{0,-1}, {1,0}, {0,1}, {-1,0}};
	static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int r = 0; r < N; r++) {
			String line = br.readLine();
			for(int c = 0; c < N; c++) {
				map[c][r] = line.charAt(c) - '0';
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1 && !visited[r][c]) {
					bfs(new int[] {r,c});
					
				}
			}
		}
		
		System.out.println(answer.size());
		Collections.sort(answer);
		for(int i : answer) {
			System.out.println(i);
		}
	}
	
	public static void bfs(int[] start) {
		Queue<int[]> q = new LinkedList<>();
		int count = 0;
		
		q.offer(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int [] current = q.poll();
			count++;
			
			for(int[] d:deltas) {
				if(isIn(current[0] + d[0],current[1]+d[1]) && (map[current[0] + d[0]][current[1]+d[1]] == 1) && (!visited[current[0] + d[0]][current[1]+d[1]])){
					visited[current[0] + d[0]][current[1]+d[1]] = true;
					q.offer(new int [] {current[0] + d[0],current[1]+d[1]});
				}
			}
		}
		if(count > 0) answer.add(count);
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r <N && c >= 0 && c < N;
	}
	
}
