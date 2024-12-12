package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 문제집 {
	
	static int N,M;
	static List<Integer>[] li;
	static PriorityQueue<Integer> q;
	static boolean[] visited;
	static int[] cnt;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		li = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		cnt = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			li[num1].add(num2);
			cnt[num2]++;
		}
		
		q = new PriorityQueue<Integer>();
		for(int i = 1; i <= N; i++) {
			if(cnt[i] == 0) {
				q.add(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			
			int n = q.poll();
			sb.append(n).append(" ");
			
			
			for(int i = 0; i < li[n].size(); i++) {
				cnt[li[n].get(i)]--;
				if(cnt[li[n].get(i)] == 0) {
					q.add(li[n].get(i));
				}
				
			}
			
		}
		
		System.out.println(sb.toString());
	}

}
