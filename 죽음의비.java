package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 죽음의비 {
	
	static int N, H, D;
	static List<int[]> li;
	static boolean[] visited;
	static int sr, sc;
	static int er, ec;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		li = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			
			for(int j = 0; j < N; j++) {
				if(c[j] == 'S') {
					sr = i;
					sc = j;
				} if(c[j] == 'U') {
					li.add(new int[]  {i,j});
				}
				if(c[j] == 'E') {
					er = i;
					ec = j;
				}
			}
	
			
		}
		answer = Integer.MAX_VALUE;
		visited = new boolean[li.size()];
		dfs(sr, sc, H, 0, 0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	
	static void dfs(int r, int c, int h, int d, int cnt) {
		
		//System.out.println(r +" " + c + " " + h+ " "+ d + " " +cnt);

		int dist = Math.abs(r - er) + Math.abs(c - ec);
	
		if((h+d) - dist >= 0) {
			answer =Math.min(answer, cnt + dist);
			return;
		}
		
		for(int i = 0; i < li.size();i++) {
			if(visited[i] == true)
				continue;
			
			visited[i] = true;
			dist = Math.abs(r - li.get(i)[0]) + Math.abs(c - li.get(i)[1]);
	
			if(h + d >= dist) {
				if(d - dist > 0)
					dfs(li.get(i)[0],li.get(i)[1],h,D, cnt + dist);
				else
					dfs(li.get(i)[0],li.get(i)[1],h-(dist-d), D, dist+cnt);
			}
			visited[i] = false;
			
		}
		
	}

}
