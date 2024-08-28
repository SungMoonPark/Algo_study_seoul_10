package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
public class 부분수열의합_14225 {

	static int N;
	static int[] map;
	static int idx;
	static List<Integer> arr;
	static Set<Long> s;
	static long cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 
		N = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		
		map = new int[N];
		for(int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		s = new HashSet<>();

		check(0,0);
		
		cnt = 1;
		

		while(true) {
			if(!(s.contains(cnt))) {
				System.out.println(cnt);
				break;
			}
			cnt++;
		}
	
	}
		

	private static void check(int cnt, long sum) {
		if(cnt == N) {
			if(sum!=0) {
				s.add(sum);
			}
			return;
		}
		
		check(cnt+1, sum + map[cnt]);
		check(cnt+1,sum);
	}

}
