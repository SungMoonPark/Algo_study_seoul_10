package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴감소하는부분순열 {
	
	static int N;
	static int[] map;
	static int[] dp;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				if(map[i] > map[j]) {
					dp[j] = Math.max(dp[j], dp[i]+1); 
					answer = Math.max(dp[j], answer);
				}
			}
		}
		
		System.out.println(answer+1);
		
	}

}
