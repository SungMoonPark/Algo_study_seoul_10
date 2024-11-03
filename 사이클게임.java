package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 사이클게임 {
	
	static int N, M;
	static int[] p;
	static int[] r;
	static int answer;
	static boolean no;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		p= new int[N];
		r = new int[N];
		for(int i = 0; i < N; i++) {
			p[i] = i;
			r[i] = 1;
		}
		
		answer = 1;
		no = true;
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			a = check(a);
			b = check(b);
			if(a==b) {
				no = false;
				System.out.println(answer);
				break;
			} else {
				if(r[a] >= r[b]) {
					p[b] = a;
					r[a]+=r[b];
					
				} else {
					p[a]= b;
					r[b]+=r[a];
				}
				
			}
			answer++;
			//System.out.println(Arrays.toString(p));
			
		}
		
	
		
		if(no == true) {
			System.out.println(0);			
		}
		
		
	}
	
	static int check(int num) {
		if(p[num] == num) {
			return num;
		} else {
			return p[num] = check(p[num]);
		}
	}

}
