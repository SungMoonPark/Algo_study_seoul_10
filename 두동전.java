package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두동전 {
	static int N, M;
	static char[][] map;
	static int[][] idx;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	static int min;
	static int[][] tmp;
	static int nr1, nc1, nr2,nc2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		idx = new int[2][2];
		tmp = new int[2][2];
		int n = 0;
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 'o') {
					idx[n][0] = i;
					idx[n++][1] = j;
				}
			}
		}

		min = 11;
		coin(0, idx[0][0], idx[0][1], idx[1][0], idx[1][1]);
		
		if(min == 11) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	static void coin(int cnt, int r1, int c1, int r2, int c2) {
		if(cnt > 10)
			return;
		
		if( (check(r1,c1) && !check(r2,c2)) || (!check(r1,c1) && check(r2,c2))) {
			min = Math.min(min, cnt);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			nr1 = r1 + dr[i];
			nc1 = c1 + dc[i];
			
			nr2 = r2 + dr[i];
			nc2 = c2 + dc[i];
			
			if(check(nr1,nc1) && check(nr2,nc2))
				continue;
			
			if(!(check(nr1,nc1)) && map[nr1][nc1] == '#'){
				nr1= r1;
				nc1 = c1;
			}
			
			if(!(check(nr2,nc2)) && map[nr2][nc2] == '#'){
				nr2= r2;
				nc2 = c2;
			}
			
			
			
			coin(cnt+1, nr1,nc1,nr2,nc2);
			
		}
		
		
	
	}
	
	static boolean check(int r, int c) {
		return r>= N || r < 0 || c>=M || c <0;
	}
	

}
