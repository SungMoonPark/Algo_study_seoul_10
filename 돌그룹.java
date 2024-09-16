package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 돌그룹 {
	
	static int A,B,C;
	static Queue<int[]> q;
	static boolean answer;
	static boolean[][] visited;
	static int total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A  = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		total = A+B+C;
		q = new LinkedList<>();
		q.offer(new int[] {A,B});
		answer = false;
		visited = new boolean[total+1][total+1];
		
		bfs();
		
		if(answer == true)
			System.out.println(1);
		else
			System.out.println(0);

		
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			int a = idx[0];
			int b = idx[1];

			
			int c = total -a -b;
			
			if(a==b && b== c && c==a) {
				answer= true;
				return;
			}
			
			if(a!=b) {
				int min = Math.min(a,b);
				int ab1 = min * 2;
				int ab2 = Math.max(a, b) - min;
				
				if(!visited[ab1][ab2]) {
					visited[ab1][ab2] = true;
					q.offer(new int[] {ab1, ab2, c});
				}			
			}
			
			if(c!=b) {
				int min = Math.min(c,b);
				int bc1 = min * 2;
				int bc2 = Math.max(c, b) - min;
				
				if(!visited[bc1][bc2]) {
					visited[bc1][bc2] = true;
					q.offer(new int[] {a, bc1, bc2});
				}			
			}
			
			if(a!=c) {
				int min = Math.min(a,c);
				int ac1 = min * 2;
				int ac2 = Math.max(a, c) - min;
				
				if(!visited[ac1][ac2]) {
					visited[ac1][ac2] = true;
					q.offer(new int[] {ac1, b, ac2});
				}			
			}
			
		}
		
	}
	

}