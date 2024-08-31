package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스나이트 {
	static int N;
	static int[][] map;
	static int r1,c1;
	static int r2,c2;
	static int nr,nc;
	static int rIdx, cIdx;
	static int[] dr = {-2,-2,0,0,2,2};
	static int[] dc = {-1,1,-2,2,-1,1};
	static boolean answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		answer = false;
		knight(r1,c1);

		if(answer == true) {
			System.out.println(map[r2][c2]-1);
		}
		else {
			System.out.println(-1);
		}
	}
	static void knight(int r, int c) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(r);
		q.offer(c);
		map[r][c] = 1;
		
		while(!q.isEmpty()) {
			rIdx = q.poll();
			cIdx = q.poll();
			
			if(rIdx  == r2 && cIdx == c2) {
				answer = true;
				return;
			}
			
			for(int i = 0; i < dr.length; i++) {
				nr = rIdx + dr[i];
				nc = cIdx + dc[i];
				
				if(check(nr,nc)) continue;
				if(map[nr][nc] != 0) continue;
				
				q.offer(nr);
				q.offer(nc);
				
				map[nr][nc] = map[rIdx][cIdx] + 1;
				
			}
			
		}
		
	}
	static boolean check(int r, int c) {
		return r >= N || r < 0 || c >= N || c < 0;
	}
	
}
