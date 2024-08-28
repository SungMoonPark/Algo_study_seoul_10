package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 부분수열의합_1182 {

	static int N, S;
	static int[] map;
	static int tmp;
	static int[] tmpMap;
	static int cnt;
	static int answer;
	static int idx;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		map = new int[N];
		for(int i = 0; i< N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
 		}
		
		answer = 0;
		
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N];
			cnt = i;
			tmp = 0;
			check(0,0);
		}
		System.out.println(answer);

	}
	
	static void check(int i, int start) {
		if(cnt == i) {
			if(tmp == S) {
				answer+=1;
			}
			return;
		}
		
		for(int j = start; j < N; j++) {
			tmp += map[j];
			check(i+1 ,j+1);
			tmp -= map[j];
		}	
	}

}
