import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1_10989_수정렬하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int [] nums = new int [10001];
		for(int i= 0; i < N; i++) {
			nums[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 0; i < 10001; i++) {
			while(nums[i] > 0) {
				sb.append(i).append("\n");
				nums[i]--;
			}
		}
		System.out.println(sb);
	}

	
}
