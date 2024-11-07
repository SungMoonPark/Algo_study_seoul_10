package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나머지합 {
	
	static int N, M;
	static long[] dp;
	static long[] cnt;
	static long answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st  = new StringTokenizer(br.readLine());
		
		dp = new long[N+1];
		cnt = new long[M];
		dp[0] = 0;
		answer = 0;
		for(int i = 1; i <= N; i++) {
			
			
			int num = Integer.parseInt(st.nextToken());
			
			dp[i] = dp[i-1] + num;
			if(dp[i]%M ==0) {
				answer++;
			}
			
			cnt[(int)(dp[i]%M)]+=1;
			
		}
		
		
		for(int i = 0; i<M;i++) {
			if(cnt[i] > 1) {
				answer += (cnt[i] * (cnt[i]-1)/2);
			}
		}
		
		System.out.println(answer);
		
		

	}

}
