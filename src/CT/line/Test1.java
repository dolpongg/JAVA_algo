package CT.line;
import java.util.HashMap;

public class Test1 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}}));
	}
	
	static public int solution(int[][] queries) {
		int answer = 0;
		//배열 번호 : [현재 들어있는 수, 크기]
		HashMap<Integer, int[]> map = new HashMap<>();
		
		
		for(int[] query : queries) {
			if(map.containsKey(query[0])) {
				int [] tmp = map.get(query[0]);

				if(tmp[1] < tmp[0]+query[1]) {
					answer += tmp[0];
//					System.out.println(tmp[0]+query[1] + " : " + tmp[1] + " : " + answer);
					tmp[1] = minPow(tmp[0]);
				}
				map.put(query[0], new int[] {tmp[0] + query[1], tmp[1]});
			}else {
				map.put(query[0], new int[] {query[1], minPow(query[1])});
			}
		}
		
		
		
		return answer;
	}
	
	static public int minPow(int num) {
		int powNum = 1;
		while(num > powNum) {
			powNum *= 2;
		}
//		System.out.println(num + " : " + powNum);
		return powNum;
	}
}
