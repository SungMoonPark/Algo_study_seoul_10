package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 아우으우아으이야 {
	static long answer;
	static int left;
	static int right;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		answer = 0;
		st = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());

		for(int i = 1; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			

			if(l >= left && l < right) {
				if(r >= right) {
					right = r;
				} 				
				continue;
			}
			
			if(l >= right) {
				answer += right- left;
				left = l;
				right = r;
			}
			
		}
		
		answer +=right- left;
	
		System.out.println(answer);

	}

}
