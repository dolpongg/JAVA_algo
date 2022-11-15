package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bronze1_1157_단어공부 {
	static Map<Character, Integer> alpha = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		char[] charInput = input.toUpperCase().toCharArray();
		
		for(char c : charInput) {
			if(alpha.containsKey(c)) {
				alpha.put(c, alpha.get(c)+1);
			}else {
				alpha.put(c, 1);
			}
		}
		
		if(alpha.size() == 1) {
			System.out.println(charInput[0]);
			return;
		}
		if(alpha.size() == 0) {
			System.out.println("?");
			return;
		}
		List<Character> keySet = new ArrayList<>(alpha.keySet());
		
		keySet.sort(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				// TODO Auto-generated method stub
				return alpha.get(o1).compareTo(alpha.get(o2)) * -1;
			}
			
		});
		
		if(alpha.get(keySet.get(0)).equals(alpha.get(keySet.get(1)))) {
			System.out.println("?");
		}else {
			System.out.println(keySet.get(0));
		}
		
	}
}
