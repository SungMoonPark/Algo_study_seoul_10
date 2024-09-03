package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에너지모으기 {

	static int N;
	static int[] map;
	static boolean[] visited;
	static int max;
	static int num1, num2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new int[N];
		visited = new boolean[N];
		
		for(int i=0; i < N; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		max = 0;
		check(0,0);
		System.out.println(max);
	}
	
	static void check(int cnt, int sum) {
		if(cnt == N-2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 1; i < N-1; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			
			for(int j = i-1; j >= 0; j--) {
				if(visited[j]) continue;
				num1 = map[j];
				break;
			}
			
			for(int j = i+1; j < N; j++) {
				if(visited[j]) continue;
				num2 = map[j];
				break;
			}
			
			check(cnt+1, sum + (num1*num2));
			
			visited[i] = false;
		}
		
	}


}
