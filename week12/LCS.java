package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LCS {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String x = br.readLine();
		String y =br.readLine();

//		Map<Character, Integer> map = new HashMap();
//		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		for(int i = 0; i < alpha.length();i++) {
//			map.put(alpha.charAt(i), i);
//		}
		
		int[][] dp = new int[x.length()+1][y.length()+1];


		for(int i = 1; i <= x.length(); i++) {
			for(int j = 1; j <= y.length(); j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					dp[i][j] = (dp[i-1][j-1]) + 1;
				} else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}

		
		System.out.println(dp[x.length()][y.length()]);
		
	}

}
