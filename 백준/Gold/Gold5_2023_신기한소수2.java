package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author dolpong
 * @date 2022.08.05 
 * @url https://www.acmicpc.net/problem/2023
 * @git
 * @performance 12892	884
 * @category 
 * @note 
 */

public class Gold5_2023_신기한소수2 {
	static int [] numArr = {1,3,7,9};
	static int[] start = {2,3,5,7};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int num : start) {
			makePermutationDup(1, num);
		}

	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i*i < num; i++) {
			if(num%i == 0)return false;
		}
		return true;
		
	}
	
   
	static void makePermutationDup(int nth, int choosed) {
    	if(!isPrime(choosed)) return;
    	if (nth == N) {
    		System.out.println(choosed);
            return;  
        }

        for (int i = 0; i < numArr.length; i++) {
            makePermutationDup(nth + 1, choosed*10 + numArr[i]);
        }
    }

}
