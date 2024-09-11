package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
 			}
		}
		
		max = 0;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				check2(i,j);
				visited[i][j] = true;
				answer(1,map[i][j],i,j);
				visited[i][j] = false;
			}
		}
		
		
		System.out.println(max);
	}
	
	static void answer(int cnt, int sum, int r, int c) {
		if(cnt==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr,nc)) continue;
			if(visited[nr][nc]) continue;

			visited[nr][nc] = true;
			answer(cnt+1, sum + map[nr][nc], nr, nc);
			visited[nr][nc] = false;
			
		}
		
	}
	
	static void check2(int r, int c) {
		int sum = map[r][c];
		int min = 1001;
		int cnt = 0;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(check(nr,nc)) {
				cnt++;
				continue;
			}
			sum += map[nr][nc];
			min = Math.min(map[nr][nc], min);
		}
		
		if(cnt>=2)
			return;
		if(cnt == 0)
			max = Math.max(max, sum - min);
		else
			max = Math.max(max,sum);
	}
	
	static boolean check(int r, int c) {
		return r >= N || r < 0 || c>=M || c < 0;
	}

}
