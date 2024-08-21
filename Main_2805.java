package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
	static int N, M;
	static int[] map;
	static int cnt,tmp;
	static int idx;
	static long[] dp;
	static long max;
	static long left, right, mid;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		map = new int[N];
		max = 0;
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, map[i]);
		}
		
		Arrays.sort(map);
		left = 0;
		right = max;
		
		while(true) {
			mid = (left+right)/2;
			cnt = 0;
			for(int i = N-1; i >=0; i--) {
				if(map[i] < mid)
					break;
				cnt+= (map[i] - mid);
			}
			
			if(cnt == M) {
				break;
			}
			if(cnt < M)
				right = mid-1;
			else {
				left = mid+1;
			}
		}
		
		System.out.println(mid);
	}
	
}
