package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 사다리 {
	
	static int N, L;
	static class Ladder {
		int left, right, d;
		
		Ladder(int left, int right, int d){
			this.left = left;
			this.right = right;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Ladder [left=" + left + ", right=" + right + ", d=" + d + "]";
		}
		
		
	}
	static Ladder[] map;
	static int answer;
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new Ladder[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(d == 0) {
				int left = 0;
				int right = n-1;
				map[i] = new Ladder(left, right, d);
				
			}
			else {
				int right = L-1;
				int left = right-n;
				map[i] = new Ladder(left, right, d);
				
			}
		}
		
		int cnt = 0;
		answer = 0;
		
		while(true) {
			
			if(cnt == N-1) {
				System.out.println(answer);
				
				return;
			}
			
			if(map[cnt].left <= map[cnt+1].left && map[cnt].right >= map[cnt+1].left) {

				cnt++;
				continue;
			}
			if(map[cnt+1].left <= map[cnt].left && map[cnt+1].right >= map[cnt].left) {

				cnt++;
				continue;
			}
			
			
			for(int i = 0; i < N; i++) {
				
				int left = map[i].left;
				int right = map[i].right;
				int d = map[i].d;
				
				if(left == 0 && right == L-1) {
					continue;
				}
				if(d == 0) {
					if(left == 0) {
						map[i].d = 1;			
						map[i].right +=1;
						map[i].left+=1;
					}
					else {
						map[i].left-=1;
						map[i].right-=1;
					}
				} else {
					if(right == L-1) {
						map[i].d = 0;			
						map[i].right -=1;
						map[i].left-=1;
					}
					else {
						map[i].left+=1;
						map[i].right+=1;
					}
				}
				
			}
			
			answer++;
			
		}
		
	}

}
