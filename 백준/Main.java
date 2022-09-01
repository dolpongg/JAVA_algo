import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N ;
	static boolean[] visited;
	
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	N = sc.nextInt();
	int M = sc.nextInt();
	visited = new boolean[N];
	com(0, new int [M], visited);
	
}
  public static void com(int nth, int[] choosed, boolean [] visited) {
	  if(nth == choosed.length) {
		  for(int i : choosed) {
			  System.out.printf("%d ", i);
		  }
		  System.out.println();
		  return;
	  }
	  
	  for(int i = 0; i < N; i++) {
		   if(!visited[i]) {
			   visited[i] = true;
			   choosed[nth] = i+1;
			   com(nth+1, choosed, visited);
			   
			   visited[i] = false;
		   }
	   }
  }
}