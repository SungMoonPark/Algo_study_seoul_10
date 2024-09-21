package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 여행가자 {
	static int N, M;
	static boolean[] visited;
	static List<Integer>[] li;
	static int[] map;
	static Queue<Integer> q;
	static boolean answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		li = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					li[i].add(j);
				}
			}
			
		}
		map = new int[M];
		visited = new boolean[N+1];		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
	
		q = new LinkedList<>();
		q.addAll(li[map[0]]);
		visited[map[0]] = true;
		
		
		check();
		answer =true;
		for(int n : map) {
			if(!visited[n]) {
				answer = false;
				break;
			}
		}
		
		if(answer==true) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}
	
	static void check() {
		
		while(!q.isEmpty()) {
			int n = q.poll();
			if(visited[n])
				continue;
			
			visited[n] = true;
			
			q.addAll(li[n]);
			
		}
		
	}
	
}
