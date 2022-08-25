import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 프림 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		
		int [] minEdge = new int[V]; // 각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용중 최소 비
		boolean[] visited = new boolean[V]; // 신장 트리에 포함 여부
		
		
		//1. ㅇ임의의 시작점 처리, 0번 정점을 신장트리의 구성의 시작점
		//2. 최소 신장 트리의 비용을 누적시킬 변수
		
		//V개의 정점 처리하면 끝
		//Step1. 신장트리의 구성에 포함되지 않은 정점 중 최소 비용 정점 선택
	}
	
	
	
}
