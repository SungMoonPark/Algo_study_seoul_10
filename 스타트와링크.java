package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {
	
	static int N;
	static int[][] map;
	static int tmp1, tmp2;
	static boolean[] visited;
	static int min;
	static boolean end;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
			
		}
		min = 100;
		check(0,0);
		System.out.println(min);
	

	}
	
	static void check(int cnt, int start) {
		
		if(cnt == N/2) {
			tmp1 = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					if(visited[i] != visited[j]) continue;
					if(visited[i]) {
						tmp1 += map[i][j];
						tmp1 += map[j][i];
					}
					else {
						tmp1 -= map[i][j];
						tmp1 -= map[j][i];
					}
				}
			}
			
			min = Math.min(min, Math.abs(tmp1));
			return;
		}
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			
			check(cnt + 1, i+1);
			
			visited[i] = false;
			
		}
		
	}

}
