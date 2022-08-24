import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		
		
		if(G == S) {
			System.out.println(0);
		}
		else if(G > S) {
			int gap = G-S;
			if(U == 0) {
				System.out.println("use the stairs");
				return;
			}
			if(gap % U == 0) {
				System.out.println(gap / U);
				return;
			}else {
				
				if(D==0 || gap%U%D != 0 || S + U * ((gap / U) + 1) > F) {
					System.out.println("use the stairs");
					return;
				}
				System.out.println((gap / U +1) + (gap%U)/D);
				return;
			}
		}else{
			int gap = S-G;
			if(D == 0) {
				System.out.println("use the stairs");
				return;
			}
			if(gap % D == 0) {
				System.out.println(gap / D);
				return;
			}else {
				if(U == 0 || gap%D%U != 0 || G - D * ((gap / D) + 1) < 0) {
					System.out.println("use the stairs");
					return;
				}
				System.out.println((gap / D +1) + (gap%D)/U);
				return;
			}
		}
		
	}

}
