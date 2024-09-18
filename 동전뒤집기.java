package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전뒤집기 {
	static int N;
	static char[][] map;
	static char[][] tmp;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		tmp = new char[N][N];
		answer = 0;
		
		// H앞면 T뒷면
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		answer = N*N;
		
		visited = new boolean[N];
		dfs(0);
		System.out.println(answer);
	}
	
	static void dfs(int cnt) {		
		
		if(cnt == N) {
			coinCheck();
			return;
		}
		
		visited[cnt] = true;
		dfs(cnt+1);
		visited[cnt] = false;
		dfs(cnt+1);
		
		
	}
	
	static void coinCheck() {
		
		int coin = 0;
		for(int i = 0; i < N; i++) {
			int tmpCoin = 0;
			for(int j = 0; j < N; j++) {
				if(visited[j]) {
					if(map[j][i] == 'H')
						tmpCoin++;
				} else {
					if(map[j][i] == 'T')
						tmpCoin++;
				}
			}
			
			coin += Math.min(tmpCoin, N - tmpCoin);
			
			if(coin >= answer)
				return;
		}
		
		if(answer > coin) {
			answer = coin;
			return;
		}
		
		
	}
}
