package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver3_15651_N과M3 {
	static int N ;
	
	static StringBuilder sb = new StringBuilder();
	
  public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	
	com(0, new int[M], 0);
	System.out.println(sb);
	
}
  public static void com(int nth, int[] choosed, int start) {
	  if(nth == choosed.length) {
		  for(int i : choosed) {
			  sb.append(i).append(" ");
		  }
		  sb.append("\n");
		  return;
	  }
	  
	  for(int i = start; i < N; i++) {
		   choosed[nth] = i+1;
		   com(nth+1, choosed, i);			   
		   }
	  }
  
}