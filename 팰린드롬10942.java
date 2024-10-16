package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬10942 {
	static int N;
	static int[] map;
	static int M;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		
		
		StringBuilder sb = new StringBuilder();
		loop: for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())- 1;
			int end = Integer.parseInt(st.nextToken())-1;
			int answer = 1;
			while(start <= end) {
				if(map[start] != map[end]) {
					answer = 0;
					break;
				}
				start++;
				end--;
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
