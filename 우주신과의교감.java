package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 우주신과의교감 {
	static int N, M;
	static List<Position> li;
	static int[] p;
	static int[] r;
	static PriorityQueue<Node> q;
	static boolean[] visited;
	static class Position {
		long x,y;
		
		Position(long x, long y){
			this.x = x;
			this.y = y;
		}

	}
	static int cnt;
	
	static class Node implements Comparable<Node>{
		int s,e;
		double w;
		
		Node(int s, int e, double w){
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}
	}
	static double answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		li = new ArrayList<>();
		q = new PriorityQueue<>();
		answer = 0;
		
		p = new int[N];
		r = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			Long x = Long.parseLong(st.nextToken());
			Long y = Long.parseLong(st.nextToken());
			
			li.add(new Position(x,y));
			p[i] = i;
			r[i] = 1;
			
		}
		
		
		
		for(int i = 0; i < N-1; i++) {
			
			for(int j = i+1; j <N;j++) {
				q.add(new Node(i,j,	Math.sqrt(Math.pow(li.get(i).x - li.get(j).x,2) + Math.pow(li.get(i).y - li.get(j).y,2))));			
			}
		}
		
		
		for(int j = 0; j < M; j++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			
			q.add(new Node(num1,num2,0));
			
		}
		
		
		answer = 0;
		cnt = 0;
		visited = new boolean[N];
		while(true) {
			
			if(cnt == N-1) {
				break;
			}
			
			Node node = q.poll();
			
			int s = find(node.s);
			int e = find(node.e);
			double w = node.w;
			
			
			if(s != e) {
				answer += w;
				
				if(r[s] >= r[e]) {
					r[s] += r[e];
					p[e] = s;
				} else {
					r[e] += r[s];
					p[s] = e;
				}
				
				cnt++;
			}
			
			
		}
			
		

		System.out.printf("%.2f", (double) Math.round(answer * 100) / 100);

	}
	
	static int find(int num) {
		if(p[num] == num)
			return num;
		else
			return p[num] = find(p[num]);
	}

}
