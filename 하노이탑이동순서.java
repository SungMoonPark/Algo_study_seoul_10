package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class 하노이탑이동순서 {
	static int N;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 1 3 7 15
		
		sb = new StringBuilder();
		
		ha(N,1,3);
		System.out.println((int)Math.pow(2, N)-1);
		System.out.println(sb.toString());
		
	}
	static void ha(int n, int s, int e) {
		if(n==1) {
			sb.append(s).append(" ").append(e).append("\n");
			return;
		}
		
		ha(n-1,s,6-s-e);
		sb.append(s).append(" ").append(e).append("\n");
		ha(n-1,6-s-e,e);
	}
	
	
}
