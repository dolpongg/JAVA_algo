import java.util.Scanner;

public class 분할정복 {
	static int callCnt1 = 0;
	static int callCnt2 = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = sc.nextInt();
		
		System.out.println(exp1(x,n));//일반적인 재귀함수 
		System.out.println(callCnt1);
		
		System.out.println(exp2(x,n));//분할 정 
		System.out.println(callCnt2);

	}
	
	private static long exp2(long x, long n) {
		callCnt2++;
		if(n == 1) return x;
		long y = exp2(x,n/2);
		return n%2 == 0 ? y * y : x * y * y;
		
	}
	
	private static long exp1(long x, long n) {
		callCnt1++;
		if(n == 1) return x;
		return x * exp1(x, n-1);
	}
	
}
