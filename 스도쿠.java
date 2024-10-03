package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스도쿠 {
	static int[][] map;
	static int N = 9;
	static int cnt;
	static int n;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cnt = 0;
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					cnt++;
			}
		}
		sb = new StringBuilder();


		su(0,0);

		
	}
	
	static void su(int r, int c) {
		
		if(c == 9) {
			su(r+1,0);
			return;
		}
		
		if(r == 9) {
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			System.exit(0);
		}
		
		if(map[r][c] == 0) {
			boolean[] check1 = vcheck(r,c);
			boolean[] check2 = hcheck(r,c);
			boolean[] check3 = gucheck(r,c);
			
			for(int i = 1; i <= N; i++) {
				if(!check1[i] && !check2[i] && !check3[i]) {
					map[r][c] = i;
					su(r,c+1);
				}
			}
			map[r][c] = 0;
			
			return;
		} else {
			su(r, c+1);
		}
		
		
	}
	
	
	static boolean[] vcheck(int r, int c) {
		boolean[] visited = new boolean[N+1];
		
		for(int i = 0; i < N; i++) {
			visited[map[r][i]] = true; 		
		}
		
		return visited;
	}
	
	
	static boolean[] hcheck(int r, int c) {
		boolean[] visited = new boolean[N+1];
		
		for(int i = 0; i < N; i++) {
			visited[map[i][c]] = true; 		
		}
		
		return visited;
	}
	
	static boolean[] gucheck(int r, int c) {
		boolean[] visited = new boolean[N+1];
		
		for(int i = r/3 * 3; i < (r/3) * 3+3; i++) {
			for(int j = c/3 * 3; j < (c/3)*3+3; j++) {		
				visited[map[i][j]] = true;
			}
		}
		
		
		return visited;
	}
	

}
