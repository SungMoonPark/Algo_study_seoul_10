package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 움직이는미로탈출 {
	
	static char[][] map;
	static int[] dr= {0,-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,0,1,1,1,0,-1,-1,-1};
	static Queue<int[]> q;
	static Queue<int[]> wall;
	static int answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[8][8];
		wall = new LinkedList<>();
		
		for(int i = 0; i < 8; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i = 7; i >=0; i--) {
			for(int j = 0; j < 8; j++) {
				if(map[i][j] == '#') {
					wall.offer(new int[] {i,j});
				}
			}
		}
		
		q = new LinkedList<>();
		q.offer(new int[] {7,0});
		answer = 0;
		
		bfs();
		System.out.println(answer);
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] idx = q.poll();
				
				int r = idx[0];
				int c = idx[1];
				if(map[r][c] == '#')
					continue;
				if(r==0 && c == 7) {
					answer = 1;
					return;
				}
				
				for(int d = 0; d < 9; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(check(nr, nc) || map[nr][nc] == '#')
						continue;
					
					q.offer(new int[] {nr,nc});
	
				}
	
			}
			
			if(wall.isEmpty()) {
				answer = 1;
				return;
			}
			
			int wallSize = wall.size();
			
			for(int i = 0; i< wallSize; i++) {
				int[] idx = wall.poll();
				int r = idx[0];
				int c = idx[1];
				map[r][c] = '.';
				if(check(r+1,c))
					continue;
				
				map[r+1][c] = '#';
				
				wall.offer(new int[] {r+1,c});	
			}
			
		}
	}
	
	
	static boolean check(int r, int c) {
		return  r>=8 || r< 0|| c>=8 || c < 0;
	}
	
}