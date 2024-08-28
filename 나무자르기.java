package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기 {
	static int N, M;
	static int[] map;
	static long cnt;
	static int max;
	static long left, right, mid;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		map = new int[N];
		right = 0;
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, map[i]);
		}
		
		left = 0;
		
		while(left<=right) {
			mid = (left+right)/2;
			cnt = 0;
			for(int i = 0; i < N; i++) {
				if(map[i] > mid)
					cnt+= (map[i] - mid);
			}
			
			if(cnt < M)
				right = mid-1;
			else {
				left = mid+1;
			}
		}
		
		System.out.println(right);
	}
	
}
