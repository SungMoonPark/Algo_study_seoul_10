package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
	static int N;
	static int num;
	static int answer;
	static boolean[] visited;
	static Map<Integer, String> map;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			answer = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10001];
			map = new HashMap<>();
			
			check(num, answer);

		}
		
	}
	
	static void check(int num, int answer) {
		q = new LinkedList<>();
		q.offer(num);
		map.put(num, "");
		visited[num] = true;
		
		while(true) {

			int n = q.poll();
			
//			System.out.println(n);

			int d = (n*2)%10000;

			if(!visited[d]) {
				visited[d] = true;
				map.put(d, map.get(n) + "D");
				if(d == answer) {
					System.out.println(map.get(d));
					return;
				}
				q.offer(d);
			}

			
				
			int s = n==0?9999:n-1;
			
			if(!visited[s]) {
				visited[s] = true;
				map.put(s, map.get(n) + "S");
				if(s == answer) {
					System.out.println(map.get(s));
					return;
				}
				q.offer(s);
			}
			
			
			int l = ((n/10)%100)*100 + (n%10)*10 + n/1000;
			if(!visited[l]) {
				visited[l] = true;

				map.put(l, map.get(n) + "L");
				
				if(l == answer) {
					System.out.println(map.get(l));
					return;
				}
				q.offer(l);
			}

			int r= (n%10)*1000 + (n/1000)*100 + (n/100)%10 *10 + n/10%10;
			if(!visited[r]) {
				visited[r] = true;
				map.put(r, map.get(n) + "R");

				if(r == answer) {
					System.out.println(map.get(r));
					return;
				}
				q.offer(r);
			}	
		}
		
	}
	

}
