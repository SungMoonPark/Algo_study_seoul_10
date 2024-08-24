package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부등호 {
	
	static int N;
	static String[] bo;
	static int[] tmp;
	static boolean[] visited;
	static int[] map = {0,1,2,3,4,5,6,7,8,9};
	static long max, min;
	static String maxString, minString;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		bo = new String[N];
		for(int i = 0; i < N; i++)
			bo[i] = st.nextToken();
		
		visited = new boolean[10];
		tmp = new int[N+1];
		
		max = 0;
		min = Long.MAX_VALUE;
		
		check(0);
		System.out.println(maxString);
		System.out.println(minString);

	}
	static void check(int cnt) {
		if(cnt == N+1) {
			
			String x = "";
			for(int i = 0; i < N; i++) {
				if(bo[i].equals("<")) {
					if(tmp[i+1] < tmp[i])
						return;
				} else {
					if(tmp[i+1] > tmp[i])
						return;
				}
				x += tmp[i];
			}
			
			x += tmp[N];
			long num = Long.parseLong(x);
			if(max < num) {
				max = num;
				maxString = x;
			}
			if(min > num) {
				min = num;
				minString = x;
			}
			return;
		}
		
		for(int i = 0; i < map.length; i++) {
			if(visited[i]==true) continue;
			tmp[cnt] = map[i];
			visited[i] = true;
			
			check(cnt+1);
			tmp[cnt] = 0;
			visited[i] = false;
			
		}
		
	}

}
