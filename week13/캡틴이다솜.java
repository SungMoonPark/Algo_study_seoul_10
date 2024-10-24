package baekjoon_study;

import java.util.Arrays;
import java.util.Scanner;

public class 캡틴이다솜 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		int idx = -1;
		dp[1] = 1;
		
		if(n == 1) {
			System.out.println(1);
		} else {
			 for(int i = 2; i < n; i++) {
				
				for(int j = 1; j <= i; j++) {
					dp[i] += j;
				}
				
				dp[i] += dp[i-1];
				
				if(dp[i] >= n) {
					idx=i;
					break;
				}
			}
			 //System.out.println(Arrays.toString(dp));
		int[] dp2 = new int[n+1];
		Arrays.fill(dp2, Integer.MAX_VALUE);
		dp2[0] = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= idx; j++) {
				if(i == dp[j]) {
					dp2[i] = 1;
					break;
				} else if(dp[j] > i) {
					break;
				} else {
					dp2[i] = Math.min(dp2[i-dp[j]] + dp2[dp[j]], dp2[i]);
				}
			}

		}
		//System.out.println(Arrays.toString(dp2));
		System.out.println(dp2[n]);
		}


	}

}
