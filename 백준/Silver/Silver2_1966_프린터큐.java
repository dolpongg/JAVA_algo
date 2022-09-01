package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_1966_프린터큐 {
	public static class Print implements Comparable<Print>{
		int index, p;

		public Print(int index, int p) {
			this.index = index;
			this.p = p;
		}

		@Override
		public int compareTo(Print o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.p, o.p) * -1;
		}

		@Override
		public String toString() {
			return "[" + index + ": " + p + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<Print> pq = new LinkedList<>();
			int[] sortP = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				sortP[i] = Integer.parseInt(st.nextToken());
				pq.offer(new Print(i,sortP[i]));
			}
			Arrays.sort(sortP);
			int sIndex = sortP.length-1;
			int cnt = 0;
			while(!pq.isEmpty()) {
				Print current = pq.poll();
				if(current.p < sortP[sIndex]) {
					pq.offer(current);
					continue;
				}
				cnt++;
				if(current.index == M) {
					sb.append(cnt).append("\n");
					break;
				}
				sIndex--;
			}
		}
		System.out.println(sb);
		
	}

}
