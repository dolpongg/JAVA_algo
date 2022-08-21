import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold4_트리의지름 {
	static class Node{
		int num, len;
		public Node(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
	
	static List<Node> list[];
	static boolean visited[];
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
        	list[i] = new ArrayList<>();
        }
 
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, len));
            list[to].add(new Node(from, len));
        }//입력 완료
        answer = 0;;
        
	}

}
