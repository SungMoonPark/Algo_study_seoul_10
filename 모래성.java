package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모래성 {
	static int H,W;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,-1,-1,-1,0,1,1,1};
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		q = new LinkedList<>();
		for(int i = 0; i < H; i++) {
			char[] c = br.readLine().toCharArray();
			
			for(int j = 0; j < W; j++) {
				if(c[j] == '.') {
					map[i][j] = 0;
					q.add(new int[] {i,j});
				} else {
					map[i][j] = c[j] - '0';
				}
			}
			
		}
		
		answer = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] idx = q.poll();
				
				int r = idx[0];
				int c = idx[1];
				
				for(int d = 0; d <8; d++) {
					int nr = r+dr[d];
					int nc = c+ dc[d];
					
					if(check(nr,nc) || map[nr][nc] == 0)
						continue;
					
					if(map[nr][nc] >= 1) {
						map[nr][nc]-=1;
						if(map[nr][nc] == 0) {
							q.offer(new int[] {nr,nc});
						}
					}
					
					
				}
				
				
			}
			answer++;
		}
		
		System.out.println(answer-1);
	}
	static boolean check(int r, int c) {
		return r >= H || r<0 || c>=W || c < 0;
	}
}
