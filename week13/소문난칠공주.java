import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static char[][] map;
	static int tmp;
	static int answer;
	static int[][] li;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[] visited;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();	
		}
		

		answer = 0;
		
		li = new int[7][2];
		
		sCnt(0,0);
		
		System.out.println(answer);
		

	}	
	
	
	static void sCnt(int cnt, int st) {

		if(cnt==7) {
			bfs();
			
			return;
		}
	
		for(int i = st; i < 25; i++) {
			int r = i/5;
			int c = i%5;

			li[cnt][0] = r;
			li[cnt][1] = c;
			
			sCnt(cnt+1, i+1);
		}
	
	}
	
	static void bfs() {
		tmp = 0;
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[7];
		int cnt = 1;
		q.offer(li[0]);
		visited[0] = true;
		
		while(!q.isEmpty()) {
	
			int[] idx = q.poll();
			int r = idx[0];
			int c = idx[1];
			
			
			if(map[r][c] =='S')
				tmp++;

			
			for(int d = 0; d< 4; d++) {
				int nr = r+ dr[d];
				int nc = c + dc[d];
				
				if(check(nr,nc)) continue;
				
				for(int i = 1; i < 7; i++) {
					if(li[i][0] == nr && li[i][1] == nc) {
						if(!visited[i]) {
							cnt++;
							visited[i] = true;
							q.offer(new int[] {nr,nc});
						}
					}
				}
		
			}

		}
		if(cnt==7) {
			if(tmp >= 4) {
//				System.out.println(Arrays.deepToString(li));
				answer++;
			}
			return;
		}
		
	}
	
	
	static boolean check(int r, int c) {
		return r >= 5 || r< 0 || c>=5 || c <0;	
	}

}
