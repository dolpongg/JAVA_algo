import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2_1629_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		long C = Integer.parseInt(st.nextToken());
		
		System.out.println(dc(A,B,C));

	}

	private static long dc(long a, long b, long c) {
		if(b == 1) return a%c;
		long tmp = dc(a,b/2,c)%c;
		if(b %2 == 0){
			return tmp * tmp % c;
		}else return (tmp * tmp)%c * a%c % c;
	}

}

// 10 11 12
