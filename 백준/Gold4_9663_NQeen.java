import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold4_9663_NQeen {
	static int N;
	static int [] cols;
	static int answer = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		cols = new int[N+1];
		setQeen(1);

		System.out.println(answer);
	}

	private static void setQeen(int rowN) {
		if(rowN > N) {
			answer++;
			return;
		}
		
		for(int i = 1; i<=N; i++) {
			cols[rowN] = i;
			if(isAvailable(rowN)) setQeen(rowN+1);
		}
		
	}

	private static boolean isAvailable(int rowN) {
		for(int i = 1;i < rowN; i++) {
			if(cols[rowN] == cols[i] || rowN-i == Math.abs(cols[rowN] - cols[i])) return false;
		}
		return true;
	}

}
