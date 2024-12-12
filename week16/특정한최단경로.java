package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한최단경로 {
	static int N, E;
	static class Node implements Comparable<Node>{
		int e, w;
		
		public Node(int e, int w) {
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static PriorityQueue<Node> q;

	static int answer1, answer2;
	static int v1;
	static int v2;
	
	static int[] dist;
	static boolean[] visited;
	
	static List<Node>[] li;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		li = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			li[i] = new ArrayList<>();
		}
			
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			li[s].add(new Node(e,w));
			li[e].add(new Node(s,w));
		}
	
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		
		answer1 = 0;
		answer1 += dij(1,v1);
		answer1 += dij(v1,v2);
		answer1 += dij(v2,N);
		
		answer2 = 0;
		answer2 += dij(1,v2);
		answer2 += dij(v2,v1);
		answer2 += dij(v1,N);
		//System.out.println(answer1 + " " + answer2);
		if(answer1 >= 200000*1000 && answer2 >=200000*1000) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(answer1, answer2));
		}
		
	}	
	
	static int dij(int start, int end) {
		q = new PriorityQueue<>();
		dist = new int[N+1];
		Arrays.fill(dist, 200000*1000);
		
		visited = new boolean[N+1];
		
		dist[start] = 0;
		q.offer(new Node(start,0));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int e = node.e;
			int w = node.w;
			if(!visited[e]) {
				visited[e] =true;
				
				for(Node next : li[e]) {
					if(dist[next.e] > next.w + w) {
						dist[next.e] = next.w + w;
						q.add(new Node(next.e, dist[next.e]));
					}
				}
			}
			
		}
			
		return dist[end];
	}
	
}



