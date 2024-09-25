package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기{

	static int N, M;
	static List<Integer>[] li;
	static Queue<Integer> q;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		li = new ArrayList[N+1];
		map = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			li[s].add(e);
			map[e]++;
		}
		
		q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(map[i] == 0) {
				q.offer(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int n = q.poll();
				map[n] = -1;
				sb.append(n).append(" ");
				
				for(int j : li[n]) {
					map[j]--;
				}
				
			}
			
			for(int i = 1; i <= N; i++) {
				if(map[i] == 0) {
					q.offer(i);
				}
			}		
		}
		
		System.out.println(sb.toString());
		
	}

}

