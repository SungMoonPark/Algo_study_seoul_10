package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치 {
	
	static int N, C;
	static int[] map;
	static int[] tmp;
	static int answer;
	static int cnt;
	static int prev;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[N];
		tmp = new int[C];
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(map);
		
		int left = 1;
		int right = map[N-1] - map[0];
		answer = 0;
	
		while(left <= right) {

			int mid = (left + right)/2;
			cnt = 1;
			prev = map[0];
			
			for(int i = 1; i < N; i++) {
				if(map[i] - prev >= mid) {
					cnt++;
					prev = map[i];
				}
			}
			
			if(cnt >= C) {
				answer = Math.max(answer, mid);
				left = mid+1;
			} else {
				right = mid- 1;
			}
			
			
		}
		
		System.out.println(answer);
		
	}
	
//	static void dfs(int cnt, int st) {
//		if(cnt == C) {
//			int n = Integer.MAX_VALUE;
//			for(int i = 0; i < C-1;i++) {
//				for(int j = i+1; j < C; j++) {
//					n = Math.min(n, Math.abs(tmp[i] - tmp[j]));
//				}
//			}
//			
//			answer = Math.max(n, answer);
//			return;
//			
//		}
//		
//	}


}
