package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
	static int[] arr;
	static int[] map;
	static int N;
	static int[] tmp;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N==0) {
				System.out.println(sb.toString());
				break;
			}
			
			map = new int[N];
	
			tmp = new int[N];
			
			for(int i = 0; i< N; i++)
				map[i] = Integer.parseInt(st.nextToken());
			
			
			check(0,0);
			sb.append("\n");
			
		}

	}
	static void check(int cnt, int start) {
		if(cnt == 6) {
			
			for(int j = 0; j < 6; j++)
				sb.append(tmp[j]).append(" ");
			
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			tmp[cnt] = map[i];
			check(cnt + 1, i + 1);
			
			tmp[cnt] = 0;
		}
	}

}
