package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {
	
	static int N;
	static int[] map;
	static int[] li;
	static int left, right, mid;
	static int idx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++)
			map[i] = Integer.parseInt(st.nextToken());
		
		li = new int[N];
		li[0] = map[0];
		idx = 1;
		
		for(int i = 1; i < N; i++) {
			if(map[i] > li[idx-1]) {
				li[idx++] = map[i];
				continue;
			}
			else {
				bi(map[i]);
			}
			
		}

		System.out.println(idx);
		
		
	}
	static void bi(int num) {
		left  = 0;
		right = idx;
		
		while(left < right) {
			mid = (left+right)/2;
			
			if(li[mid] < num) {
				left = mid+1;
			} else {
				right = mid;
			} 
		}
		
//		System.out.println(left + " " + right + " " + num + li); 
		li[right]= num;
		return;
		
	}

}
