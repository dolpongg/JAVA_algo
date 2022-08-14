package d4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;




public class 사칙연산유효성검사 {
	
	static String[] nodes;
	static int lastIndex;
	static int ansTmp;
	static Stack<Boolean> stack;
	static boolean status;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("./SWEA/input.txt"));
		for(int tc = 1; tc <= 10; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			nodes = new String[N+1];
			lastIndex = 0;
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				nodes[++lastIndex] = st.nextToken();
			}

			
			ansTmp = 1;

			status = true;
			dfsByInOrder(1);

			System.out.println("#" + tc + " " + ansTmp);
			
		}
		
		
		

	}
	
	static public void dfsByInOrder(int current) {
		
		if(current > lastIndex) {
			return;
		}
		
		dfsByInOrder(current*2);
		
		if(status == isOp(nodes[current])) {
			ansTmp = 0;
			return;
		}
		status = isOp(nodes[current]);
	
		dfsByInOrder(current*2+1);
		
		
	}
	
	static public boolean isOp(String str) {
		return str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/");
	}

}
