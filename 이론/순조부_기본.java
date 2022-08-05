import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 순조부_기본 {

	static char[] src = { 'a', 'b', 'c', 'd' };

    public static void main(String[] args) {
        // 1. src에서 3개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("순열");
        makePermutation(0, new char[3], new boolean[src.length]);

        // 2. src에서 3개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("조합");
        //makeCombination(0,new char[3], 0);

        // 3. src로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("부분집합");
        //powerSetDupPer(0, new boolean[4]);

    }
    
    //순열
    static void makePermutation(int nth, char[] choosed, boolean[] visited) {
        if(nth == choosed.length) {
        	System.out.println(Arrays.toString(choosed));
        	return;
        }
        for(int i = 0; i < src.length; i++) {
        	if(!visited[i]) {
        		choosed[nth] = src[i];
        		visited[i] = true;
        		makePermutation(nth+1, choosed, visited);
        		visited[i] = false;
        	}
        }
    }

    // abc aab   --> 중복순열
    static void makePermutationDup(int nth, char[] choosed) {
        if(nth == choosed.length) {
        	System.out.println(choosed);
        	return;
        }
        for(int i = 0; i < src.length; i++) {
        	choosed[nth] = src[i];
        	makePermutationDup(nth+1, choosed);
        }
    }

    /**
     * 조합: 중복되지 않게 뽑는데 순서가 없다!!!
     * 
     * @param nth
     * @param choosed
     * @param startIdx
     */
    static void makeCombination(int nth, char[] choosed, int startIdx) {
        
    }

    // 그럼 중복 조합은??
    static void makeCombinationDup(int nth, char[] choosed, int startIdx) {
       
    }

    /**
     *
     * @param toCheck
     *            어디까지 포함여부를 체크했냐?
     * @param checked
     *            전체 요소의 체크 상태
     */
    static void powerSetDupPer(int toCheck, boolean[] checked) {
        
    }

    static void print(boolean[] temp) {
        //System.out.println(Arrays.toString(temp));
        List<Character> selected = new ArrayList<>();
        List<Character> unselected = new ArrayList<>();
        for(int i=0; i<temp.length; i++) {
            if(temp[i]) {
                selected.add(src[i]);
            }else {
                unselected.add(src[i]);
            }
        }
        System.out.println(selected+" : "+unselected);
    }

}
