package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	
	static int N;
	static int[] cal;
	static int[] num;
	static int min, max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		cal = new int[4];
		num = new int[N];
		
		for(int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
		}
		
		min = 1000000000;
		max = -1000000000;
		
		check(1, num[0]);
		System.out.println(max);
		System.out.println(min);
		
	}
	static void check(int cnt, int sum) {
		if(cnt == N) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		if(cal[0] > 0) {
			cal[0]-=1;
			check(cnt+1, sum + num[cnt]);
			cal[0] +=1;
		}
		
		if(cal[1] > 0) {
			cal[1]-=1;
			check(cnt+1, sum - num[cnt]);
			cal[1] +=1;
		}
		
		if(cal[2] > 0) {
			cal[2]-=1;
			check(cnt+1, sum * num[cnt]);
			cal[2] += 1;
		}
		
		if(cal[3] > 0) {
			cal[3]-=1;
			check(cnt+1, sum / num[cnt]);
			cal[3] += 1;
		}
	}

}
