package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold3_16236_아기상어 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int N;
    static int [][] map;
    static Shark shark;
    static int A;
    static int [][] deltas = {{-1, 0},{1, 0},{0, -1},{0,1}};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(input.readLine());
        
        map = new int[N][N];
        for(int r=0; r<N; r++) {
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
                if(map[r][c]==9) {
                    shark = new Shark(r, c, 2, 0);
                    // 상어가 이동할꺼니까 이 자리는 청소!!
                    map[r][c]=0;
                }    
            }
        }
        A = 0;
        bfs();
        System.out.println(A);
    }
    
    static void bfs() {
        // 준비물
        Queue<Shark> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        // 초기화
        q.offer(shark);
        visited[shark.r][shark.c] = true;
        
        // 먹이를 찾아보자!!!!!
        Fish target = null;
        
        // 먹이를 찾아 가는 거리 = bfs 탐색의 depth
        int depth = 1;
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            while(size-->0) {
                Shark head = q.poll();
                for(int d=0; d<deltas.length; d++)   {
                    int nr = head.r + deltas[d][0];
                    int nc = head.c + deltas[d][1];
                    if(isIn(nr, nc) && !visited[nr][nc]) {
                        visited[nr][nc]=true;
                        // 대상 지점이 비어있거나 물고기가 상어랑 같은 크기면 이동 가능
                        if(map[nr][nc]==0 || map[nr][nc]== head.s) {
                            q.offer(new Shark(nr,  nc, head.s, head.e));
                        }
                        // 먹을 수 있는 녀석??
                        else if(map[nr][nc]< head.s) {
                            Fish fish = new Fish(nr, nc, map[nr][nc], depth);
                            if(target==null) {
                                target = fish;
                            }else {
                                target = target.compareTo(fish) >0? fish: target;
                            }
                        }
                    }
                }
            }// 한 턴
            if(target!=null) {
                break;
            }            
            depth++;            
        }   // bfs 탐색 종료
        
        if(target==null) {
            return;
        }  
        // 먹이로 이동해서 먹기!!!
        shark.eat(target);
        // 다시 새로운 탐색~~~~
        bfs();
        
    }
    
    static boolean isIn(int r, int c) {
        return 0<=r && r<N && 0<=c && c<N;
    }
    
    
    static class Shark{
        int r, c, s, e; // row, col, size, eatCnt;

        public Shark(int r, int c, int s, int e) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.e = e;
        }
        void eat(Fish fish) {
            A+=fish.d;
            this.r = fish.r;
            this.c = fish.c;
            map[fish.r][fish.c] = 0;
            e++;
            if(e==s) {
                s++;
                e=0;
            }
        }
        @Override
        public String toString() {
            return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", e=" + e + "]";
        }
    }
    
    
    static class Fish implements Comparable<Fish>{
        int r, c, s, d; // row, col, size, distance

        public Fish(int r, int c, int s, int d) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
        }

        @Override
        public int compareTo(Fish o) {
           if(this.d==o.d) {
               if(this.r == o.r) {
                   return Integer.compare(this.c, o.c);
               }else {
                   return Integer.compare(this.r, o.r);
               }
           }else {
               return Integer.compare(this.d, o.d);
           }
        }

        @Override
        public String toString() {
            return "Fish [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + "]";
        }
    }

}
