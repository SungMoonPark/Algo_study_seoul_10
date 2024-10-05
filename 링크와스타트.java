package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 링크와스타트 {
	
	static int N;
	static int[][] map;
	static int answer;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited= new boolean[N];
		
		answer = Integer.MAX_VALUE;
		
		team(0,0);
		System.out.println(answer);
		
	}
	
	static void team(int cnt, int mcnt) {
		
		if(answer==0) // 해당 로직 추가시 시간 거의 2배 차이
			return;
		
		if(cnt == N) {
			if(mcnt == 0 || mcnt == N)
				return;
			
			check();
			return;
			
		}
		
		visited[cnt] = true;
		team(cnt+1, mcnt+1);
		visited[cnt] = false;
		team(cnt+1, mcnt);
		
	}
	
	static void check() {
		int t1 = 0;
		int t2 = 0;
		
		for(int i = 0; i< N-1; i++) {
			for(int j = i+1; j < N; j++) {
				if(visited[i] != visited[j])
					continue;
				if(visited[i] && visited[j]) {
					t1 += map[i][j];
					t1 += map[j][i];
				} else {
					t2 += map[i][j];
					t2 += map[j][i];
				}
			}
		}
		
		answer = Math.min(answer, Math.abs(t1-t2));
		return;
		
		
	}

}
