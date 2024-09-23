package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
	
	static int N, M;
	static int start,end;
	static boolean[] visited;
	static int[] map;
	static int answer;
	static int[] p;
	static int[] r;
	
	static class Node implements Comparable<Node>{
		int s,e,w;
		
		Node(int e, int s, int w){
			this.e = e;
			this.s =  s;
			this.w  = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		@Override
		public String toString() {
			return "Node [s=" + s + ", e=" + e + ", w=" + w + "]";
		}		
	}
	
	
	static PriorityQueue<Node> q;
	static StringTokenizer st;
	static List<Node>[] li;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		li = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++)
			li[i] = new ArrayList<>();
		
		visited = new boolean[N+1];
		map = new int[N+1];
		
		r = new int[N+1];
		p = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			r[i] = 1;
			p[i] = i;
		}
		
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			li[e].add(new Node(e,s,w));
			
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(map, Integer.MAX_VALUE);
		q = new PriorityQueue<>();
		
		answer =Integer.MAX_VALUE;
		q.addAll(li[end]);
		map[end] = 0;
		
		
		bus();
		System.out.println(answer);
	
	}
	
	static void bus() {
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			int e = n.e;
			int s = n.s;
			int w = n.w;

			
			if(s == start) {
				answer = Math.min(answer, map[e] + w);
				continue;
			}

			
			if(answer <= map[e] + w)
				continue;
			
			if(map[s] >= map[e] + w) {
				map[s] = map[e] + w;
				q.addAll(li[s]);
			}
			
	
		}
		
		
	}

}
