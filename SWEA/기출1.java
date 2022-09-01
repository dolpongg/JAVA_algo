import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 기출1 {
	static int N;
	static Fishing[] fishing;
	static int answer;
	
	public static class Fishing implements Cloneable{
		int l, anglers;

		public Fishing(int l, int anglers) { //클래스 - 낚시터 
			this.l = l;
			this.anglers = anglers;
		}

		@Override
		public String toString() {
			return "Fishing [l=" + l + ", anglers=" + anglers + "]";
		}
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			answer = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			fishing = new Fishing[3];

			for(int i = 0; i < 3; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int anglers = Integer.parseInt(st.nextToken());
				
				fishing[i] = new Fishing(l, anglers);
			}//입력 완료
			
			//순열
			makePer(0, new int[3], new boolean[3]);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}
	private static void makePer(int nth, int[] choosed, boolean[] visited) throws CloneNotSupportedException {
		if(nth == choosed.length) {
			// 최종 처리
//			System.out.println(Arrays.toString(choosed));
			Fishing[] choosedC = new Fishing[3];
			for(int i = 0; i < 3; i++) {
				choosedC[i] = (Fishing) fishing[choosed[i]].clone();
			}
//			System.out.println(Arrays.toString(choosedC));
			fill(choosedC, 0, new boolean[N+1], 0);
			return;
		}
		
		for(int i = 0; i < fishing.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				choosed[nth] = i;
				makePer(nth+1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	private static void fill(Fishing[] choosed, int index, boolean[] seat, int moveSum) throws CloneNotSupportedException {
		if(index == choosed.length) {//세 낚시터 모두 돌았을때
//			System.out.println(Arrays.toString(choosed) + " : " + moveSum);
			answer = Math.min(answer, moveSum);
			return;
		}
		
		Fishing c = choosed[index]; //현재 낚시터
		int cnt = 0;
		int total = 0;
		
		while(true) {
			// 중간 종료 조건
			if(answer < moveSum+total + cnt) return;
			if(c.anglers >= 2) { // 남은 낚시꾼 수가 2이상이면
				int ni = c.l - cnt;
				if(isIn(ni) && !seat[ni]) {
					seat[ni] = true;
					total += (cnt + 1);
					c.anglers--;
				}
				ni = c.l + cnt;
				if(isIn(ni) && !seat[ni]) {
					seat[ni] = true;
					total += (cnt+1);
					c.anglers--;
				}
				
				if(c.anglers== 0) {
//					System.out.println(c + " : " + total + " : " +(moveSum + total));
					fill(choosed, index+1, Arrays.copyOf(seat, seat.length), moveSum+total);
					break;
				}
			}
			else {
				List<Integer> empty = new ArrayList<>();
				int ni = c.l - cnt;
				if(isIn(ni) && !seat[ni]) {
					empty.add(ni);
				}
				ni = c.l + cnt;
				if(isIn(ni) && !seat[ni]) {
					empty.add(ni);
				}
				
				if(empty.size() == 1) {
					seat[empty.get(0)] = true;
					total += (cnt + 1);
//					System.out.println(c + " : " + total + " : " +(moveSum + total));
					fill(choosed, index+1, Arrays.copyOf(seat, seat.length), moveSum+total);
					break;
				}
				if(empty.size() == 2 ) {
					total += (cnt+ 1);
					
					seat[empty.get(0)] = true;
					Fishing[] choosedC = new Fishing[3];
					for(int i = 0; i < 3; i++) {
						choosedC[i] = (Fishing) choosed[i].clone();
					}
//					System.out.println(c + " : " + total + " : " +(moveSum + total));
					fill(choosedC, index+1, Arrays.copyOf(seat, seat.length), moveSum+total);
					seat[empty.get(0)] = false;//다시 안 앉은 척 
					
					seat[empty.get(1)] = true;
//					System.out.println(c + " : " + total + " : " +(moveSum + total));
					fill(choosed, index+1, Arrays.copyOf(seat, seat.length), moveSum+total);
					break;
				}
			}
			cnt++;
		}
		
	}
	private static boolean isIn(int i) {
		return i >= 1 && i <= N;
	}

}
