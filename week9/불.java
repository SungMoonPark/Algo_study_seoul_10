package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 불 {
	
	static int R, C;
	static Queue<int[]> hoon;
	static Queue<int[]> fire;
	static boolean[][][] visited;
	static char[][] map;
	static int cnt;
	static boolean no;
	static StringTokenizer st;
	static int[] dr = {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		hoon = new LinkedList<>();
		fire = new LinkedList<>();
		
		map = new char[R][C];
		visited = new boolean[R][C][2];
		
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j = 0; j < C; j++) {
				if(map[i][j] =='J') {
					hoon.offer(new int[] {i,j});
					visited[i][j][0] = true;
				}
				if(map[i][j] == 'F') {
					fire.offer(new int[] {i,j});
					visited[i][j][1] = true;
				}
			}
			
		}
		

		no = true;
		cnt = 1;
		run();
		if(no == true)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(cnt);

	}
	
	static void run() {
		
		while(!hoon.isEmpty()) {
			
			int size = hoon.size();
			
			for(int i = 0; i < size; i++) {
				int[] idx = hoon.poll();
				int r = idx[0];
				int c = idx[1];
				
				if(visited[r][c][1])
					continue;
				
				for(int d = 0; d< 4; d++) {
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(check(nr,nc)) {
						no = false;
						return;
					}
					
					if(visited[nr][nc][0] || visited[nr][nc][1])
						continue;
					
					if(map[nr][nc] == '#')
						continue;
					visited[nr][nc][0] = true;
					hoon.offer(new int[] {nr,nc});		
					
				}
				
			}
			
			size = fire.size();
			
			for(int i = 0; i < size; i++) {
				int[] idx = fire.poll();
				int r = idx[0];
				int c = idx[1];
				
				
				
				for(int d = 0; d< 4; d++) {
					
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(check(nr,nc)) {
						continue;
					}
					
					if(visited[nr][nc][1])
						continue;
					
					if(map[nr][nc] == '#')
						continue;
					
					visited[nr][nc][1] = true;
					fire.offer(new int[] {nr,nc});		
					
				}
				
			}
			cnt++;
			
		}
		
	}
	
	static boolean check(int r, int c) {
		return r >= R || r< 0 || c>=C || c < 0;
	}

}
