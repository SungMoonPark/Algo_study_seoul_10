package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결 {
	static int N;
	static int M;
	static int answer;
	static class Node implements Comparable<Node>{
		int s, e, w;
		
		Node(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
		
	}
	static List<Node>[] li;
	static PriorityQueue<Node> q;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		li = new ArrayList[N+1];
		for(int i =1; i<=N; i++)
			li[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			li[s].add(new Node(s,e,w));
			li[e].add(new Node(e,s,w));
		}
		
		q = new PriorityQueue<>();
		answer = 0;
		visited = new boolean[N+1];
		
		q.addAll(li[1]);
		visited[1]  = true;
		check();
	
		System.out.println(answer);
	}
	
	static void check() {
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			if(visited[n.e]) continue;
			visited[n.e] = true;
			answer+=n.w;
			q.addAll(li[n.e]);
		}
	}

}

