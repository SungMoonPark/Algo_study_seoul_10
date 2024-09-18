package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 레이저통신 {
	
	static int W, H;
	static char[][] map;
	static int[][][] visited;
	static int[][] C;
	static int[] dr=  {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int cnt;
	static PriorityQueue<Node> q;
	static int answer;
	
	static class Node implements Comparable<Node>{
		int r,c,d,m;
		
		Node(int r, int c, int d, int m){
			this.r = r;
			this.c = c;
			this.d =d;
			this.m = m;
		}

		@Override
		public int compareTo(Node o) {
			return this.m-o.m;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		C = new int[2][2];
		map = new char[H][W];
		int idx = 0;
		for(int i = 0; i < H; i++) {
			map[i] = br.readLine().toCharArray();
			
			for(int j = 0; j < W; j++) {
				if(map[i][j] == 'C') {
					C[idx][0] = i;
					C[idx++][1] = j;
 				}
			}
		}
		
		visited= new int[H][W][4];
		
		
		for(int i = 0; i < H; i++)
			for(int j = 0; j < W; j++)
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
		
		q = new PriorityQueue<>();
		
		for(int d = 0; d< 4; d++) {
			if(!check(C[0][0] + dr[d], C[0][1] + dc[d]) && map[C[0][0] + dr[d]][C[0][1] + dc[d]]!='*') {
				q.offer(new Node(C[0][0] + dr[d], C[0][1] + dc[d], d,0));
			}
		}
		answer = Integer.MAX_VALUE;
		bfs();

		
		System.out.println(answer);
	}
		
	static void bfs() {
		
		while(!q.isEmpty()) {
			
			Node idx = q.poll();
			
			int r= idx.r;
			int c = idx.c;
			int d= idx.d;
			int m = idx.m;
			
//			System.out.println(r + " " + c + " " + d + " " + m);
			
			
			if(r == C[1][0] && c == C[1][1]) {
				answer = Math.min(answer, m);
				continue;
			}
		
	
			int nr = r + dr[d];
			int nc = c+ dc[d];
			
			if(!check(nr,nc) && map[nr][nc] != '*') {
				if(visited[nr][nc][d] > m) {
					q.offer(new Node(nr,nc,d,m));
					visited[nr][nc][d] = Math.min(visited[nr][nc][d], m);
				}
			}
			
			if(d == 0 || d== 1) {
				for(int j = 2; j < 4; j++) {
					nr = r + dr[j];
					nc = c+ dc[j];
//					System.out.println(nr + " " +nc + " " + j);
					if(!check(nr,nc) && map[nr][nc] != '*') {
						
						if(visited[nr][nc][j] > m) {
							q.offer(new Node(nr,nc,j,m+1));
							
							visited[nr][nc][j] = m+1;
						}
					}
				}	
			} else {
				for(int j = 0; j < 2; j++) {
					nr = r + dr[j];
					nc = c+ dc[j];
//					System.out.println(nr + " " +nc + " " + j);
					if(!check(nr,nc) && map[nr][nc] != '*') {
						
						if(visited[nr][nc][j] > m) {
							q.offer(new Node(nr,nc,j,m+1));
							
							visited[nr][nc][j] = m+1;
						}
						}
				}	
			} 
			

		}
		
	}
	
	static boolean check(int r, int c) {
		return r>=H || c >= W || r< 0|| c<0;
	}
		
}
