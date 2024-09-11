package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임 {
	
	static int N, M;
	static int[] moveIdx;
	static int[] movePosition;
	static int min;
	static int idx;
	static int[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		moveIdx = new int[N+M];
		movePosition = new int[N+M];
		
		for(int i = 0; i< N+M; i++) {
			st= new StringTokenizer(br.readLine());
			moveIdx[i] = Integer.parseInt(st.nextToken());
			movePosition[i] = Integer.parseInt(st.nextToken());
		}	
		
		visited = new int[101];
		
		check(1);

	}
	static void check(int idx) {

		Queue<Integer> q = new LinkedList<>();
		
		q.offer(idx);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			if(num == 100) {
				System.out.println(visited[100]);
				return;
			}
			for(int i = 1; i <= 6; i++) {
				int dice = num + i;
				if(dice > 100)
					continue;
				for(int j = 0; j < M+N; j++) {
					if(dice == moveIdx[j]) {
						dice = movePosition[j];
						break;
					}
				}
				
				if(visited[dice]!=0) continue;
				visited[dice] = visited[num] + 1;
				q.offer(dice);
				
			}
			
		}
		
	}
}