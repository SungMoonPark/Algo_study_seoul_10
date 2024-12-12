package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상어중학교 {
	
	static int N, M;
	static int[][] map;
	static int[] dr= {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int answer;
	static boolean[][] visited;
	static boolean[][] tmpVisited;
	static Queue<int[]> q;
	static Node node;
	
	static class Node {
		int r, c, cnt, rainbow;
		
		Node(int r, int c, int cnt, int rainbow){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.rainbow = rainbow;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", cnt=" + cnt + ", rainbow=" + rainbow + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		int cnt = 0;
		while(true) {
			node = null;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] >= 1 && !visited[i][j]) {
						autoplay(i,j,0);
					}
				}
			}
			
			//System.out.println(Arrays.deepToString(map));
			//System.out.println(node);
			
			if(node == null) {
				System.out.println(answer);
				break;
			}
			
			visited = new boolean[N][N];
			answer += Math.pow(node.cnt + node.rainbow ,2);
			autoplay(node.r, node.c,1);
			
			for(int j = 0; j < N; j++) {
				for(int i = N-2; i >= 0; i--) {
					
					if(map[i][j] < 0)
						continue;
					
					int tmpR = i;
					while(true) {
						tmpR++;
						
						if(tmpR>=N) {
							break;
						}
						
						if(map[tmpR][j] > -2) {
							break;
						}
						
						
					}
					
					tmpR--;
					
					if(tmpR != i) {
						map[tmpR][j] = map[i][j];
						map[i][j] = -2;
					}
					
				}
			}	
			
			//System.out.println(Arrays.deepToString(map));
			
			int[][] tmpMap = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					tmpMap[N-j-1][i] = map[i][j];
				}
			}
			
			map = tmpMap;
			
			for(int j = 0; j < N; j++) {
				for(int i = N-2; i >= 0; i--) {
					
					if(map[i][j] < 0)
						continue;
					
					int tmpR = i;
					while(true) {
						tmpR++;
						
						if(tmpR>=N) {
							break;
						}
						
						if(map[tmpR][j] > -2) {
							break;
						}
						
						
					}
					
					tmpR--;
					
					if(tmpR != i) {
						map[tmpR][j] = map[i][j];
						map[i][j] = -2;
					}
					
				}
			}	
			
			//System.out.println(Arrays.deepToString(map));
			//System.out.println();
			
		}
		
		//System.out.println(answer);
		
	}
	
	static void autoplay(int i, int j, int type) {
		
		int cnt = 1;
		int rainbow = 0;
		int num = map[i][j];
		tmpVisited = new boolean[N][N];
		visited[i][j] = true;
		tmpVisited[i][j] = true;
		
		q = new LinkedList<>();
		q.add(new int[] {i,j});
	
		
		while(!q.isEmpty()) {
			
			int[] idx = q.poll();
			
			
			int r = idx[0];
			int c = idx[1];
			
			if(type == 1) {
				map[r][c] = -2;				
			}
			
			
			for(int d = 0; d < 4; d++) {
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(check(nr,nc) || map[nr][nc] < 0)
					continue;
				
				if(tmpVisited[nr][nc])
					continue;
				
				if(map[nr][nc] == num) {
					visited[nr][nc] = true;
					tmpVisited[nr][nc] = true;
					cnt++;
					q.add(new int[] {nr,nc});
				
 				}
				
				if(map[nr][nc] == 0) {
					tmpVisited[nr][nc] =true;
					rainbow++;
					q.add(new int[] {nr,nc});
				}
				
				
			}	
			

		}
		
		if(type == 0 && cnt + rainbow >= 2) {
			
			if(node == null) {
				node = new Node(i,j,cnt,rainbow);
				return;
			} else {
				if(node.cnt + node.rainbow > cnt + rainbow) {
					return;
				}
				
				if(cnt + rainbow> node.cnt + node.rainbow) {
					//System.out.println(cnt+ " " + rainbow + " " + node.cnt + " " + node.rainbow);
					node = new Node(i,j,cnt,rainbow);
					return;
				} 
				
				if(node.rainbow > rainbow) {
					return;
				}
				
				if(rainbow > node.rainbow) {
					//System.out.println(cnt+ " " + rainbow + " " + node.cnt + " " + node.rainbow);
					node = new Node(i,j,cnt,rainbow);
					return;
				} 
				
				if(node.r > i)
					return;
				
				if(i > node.r) {
					//System.out.println(cnt+ " " + rainbow + " " + node.cnt + " " + node.rainbow);
					node = new Node(i,j,cnt, rainbow);
					return;
				} 
				
				if(j > node.c) {
					//System.out.println(cnt+ " " + rainbow + " " + node.cnt + " " + node.rainbow);
					node = new Node(i,j,cnt, rainbow);
					return;
				}
				
			}
			//System.out.println("d" + node.toString());
		}
		
		return;
		
	}
	
	
	
	static boolean check(int r, int c) {
		return r>=N || r< 0 || c>= N || c < 0;
	}

}

