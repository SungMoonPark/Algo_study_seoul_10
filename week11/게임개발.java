import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] answer;
	static int[] map;
	static boolean[] visited;
	static Queue<Integer> q;
	static List<Integer>[] li;
	static int[] c;
	static int[] count;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1];
		answer = new long[N+1];
		count = new int[N+1];
		q = new LinkedList<>();
//		q = new PriorityQueue<>((o1,o2) -> {
//			return o1[1] - o2[1];
//		});
		
		li = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			li[i] = new ArrayList<>();
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			answer[i] = num;
			map[i] = num;
			
			int cnt = 0;
			while(true) {
				num = Integer.parseInt(st.nextToken());
				if(num == -1)
					break;
				li[num].add(i);
				count[i]++;
				cnt++;
			}		
			
			if(cnt == 0)
				q.offer(i);
		}
		
		visited = new boolean[N+1];
		check();
		//System.out.println(Arrays.toString(visited));
		StringBuilder sb =new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(answer[i]).append("\n");
		}
		
		System.out.println(sb.toString());

	}
	static void check() {
		while(!q.isEmpty()) {
			int num = q.poll();
			//System.out.println(num);
			for(int i = 0; i < li[num].size(); i++) {
				int n = li[num].get(i);
				count[n]--;
				answer[n] = Math.max(answer[num] + map[n], answer[n]);
				if(count[n]==0) {
					q.offer(n);
				}
			}
			//System.out.println(Arrays.toString(answer));
			
		}
		
		
	}
}

