package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Silver5_1181_단어정렬 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			String tmp = br.readLine();
			if(!list.contains(tmp)) {
				list.add(tmp);
			}
		}//입력 완료 
		
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(), o2.length());
			}
			
		});
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
