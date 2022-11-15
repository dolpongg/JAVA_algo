package d3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author dolpong
 * @date 22.08.05
 * @url https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
 * @git
 * @performance
 * @category 
 * @note 
 */

public class 암호생성기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {

			
			int TC = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> que = new LinkedList<>();
			
			for(int i = 0; i < 8; i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			int i = 0;
			
			while(true) {
				int tmp = que.poll()-(i%5+1);
				if(tmp < 1) {
					tmp = 0;
				}
				que.add(tmp);
				if(tmp == 0)break;
				i++;
			}
			
			StringBuilder sb = new StringBuilder("#");
			sb.append(tc).append(" ");
			for(int i1 = 0; i1 < 8; i1++) {
				sb.append(que.poll()).append(" ");
			}
			System.out.println(sb);
		}
	}
	
	
}
