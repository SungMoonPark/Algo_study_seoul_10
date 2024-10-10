import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] map;
	static int[][] tmpMap;
	static int answer;
	static boolean[][] visited;
	static Queue<int[]> q;
	static Queue<int[]> q2;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tmpMap = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		q = new LinkedList<>();
		q2 = new LinkedList<>();
		answer = 1;
		while(true) {
			
			//System.out.println(Arrays.deepToString(map));
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 0)
						q.offer(new int[] {i,j});
				}
			}
			
			if(q.size() == 0) {
				System.out.println(0);
				break;
			}
			
			
			for(int i = 0; i < N; i++)
				tmpMap[i] = Arrays.copyOf(map[i], M);
			
			bfs();
			
			for(int i = 0; i < N; i++)
				map[i] = Arrays.copyOf(tmpMap[i], M);
			
			int tmp = 0;
	
				visited= new boolean[N][M];
				while(!q2.isEmpty()) {
					int[] idx = q2.poll();
					int r = idx[0];
					int c = idx[1];
					
					if(!visited[r][c]) {
						dfs(r,c);
						tmp++;
					}
				}
				
				if(tmp>= 2) {
					System.out.println(answer);
					break;
				}
				
			
			
			answer++;

		}
		
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			
			int[] idx = q.poll();
			int r = idx[0];
			int c = idx[1];
			
			int tmp = 0;
			for(int d = 0; d< 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(check(nr,nc))
					continue;
				
				if(map[nr][nc] == 0)
					tmp++;

			}
			
			tmpMap[r][c] = Math.max(0, map[r][c] - tmp);
			if(tmpMap[r][c]>0)
				q2.offer(new int[] {r,c});
			
		}
		
	}
	
	static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		for(int d = 0; d< 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr,nc))
				continue;
			
			if(!visited[nr][nc] && map[nr][nc] != 0)
				dfs(nr,nc);

			
		}
		
		
	}
	
	static boolean check(int r, int c) {
		return r>= N || r < 0 || c >= M || c < 0;
	}

}
