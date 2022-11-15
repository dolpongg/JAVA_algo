package CT.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public class test2 {

	public static void main(String[] args) {
		System.out.println(solution(2, new String[] {"slang", "badword"}, "badword ab.cd bad.ord .word sl.. bad.word"));
		if(Pattern.matches(".{1,5}.{1,5}", "abcde")) {
			System.out.println(1);
		}
	
	}
	
	static public String solution(int k, String[] dic, String chat) {
		String[] chatArr = chat.split(" ");
		System.out.println(Arrays.toString(chatArr));
		List<String> dicList = Arrays.asList(dic);
		List<String> ansList = new ArrayList<>();
		
	
		outer : for(String ch : chatArr) {
			if(dicList.contains(ch)) {
				ansList.add("#".repeat(ch.length()));
			}else {
				for(String slg : dic) {
					String chtmp = ch.replace(".", ".{1," + Integer.toString(k) + "}");
					if(Pattern.matches(chtmp, slg)) {
						ansList.add("#".repeat(ch.length()));
						continue outer;
					}
				}
				ansList.add(ch);
			}
		}
		
		
		String answer = String.join(" ", ansList);
		return answer;
	}

}
