package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소수경로 {
	
	static int T;
	static int N = 10000;
	static int cnt;
	static int[] map;
	static int start, end;
	static boolean[] no;
	static Queue<Integer> q;
	static int answer;
	static int same;
	static boolean im;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		cnt = 10000-2;
		
		no = new boolean[N];
		
		for(int i = 2; i < N; i++) {
			if(no[i])
				continue;
			for(int j = i+1; j <N; j++) {
				if(no[j])
					continue;
				if(j % i == 0) {
					no[j] = true;
					cnt-=1;
				}
			}
			if(i < 1000)
				cnt-=1;
		}
		
		map = new int[cnt];
		int idx = 0;
	
		for(int i = 1000; i < N; i++) {
			if(no[i])
				continue;
			map[idx++] = i;
		}
	

		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			no = new boolean[N];
			q = new LinkedList<>();
			
			answer = 0;

			im = true;
			q.offer(start);
			bfs();

			if(im == false)
				System.out.println(answer);
			else
				System.out.println("Impossible");
		}
		

	}
	

	
	static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int n = q.poll();

				if(n == end) {
					im = false;
					return;
				}
				no[n] = true;
				
				
				
				for(int j = 0; j < cnt; j++) {
					int num = map[j];
					if(no[num])
						continue;
					same = 0;
					if(num/1000 == n/1000) {
						same++;
					}
					if(n/100 %10 == num/100%10) {
						same++;
					}
					if(n/10 %10 == num/10%10) {
						same++;
					}
					if(n%10 == num%10) {
						same++;
					}
					if(same >=3)
						q.offer(num);
				}
				
			}
			answer++;
		}
	}

}
