package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;

public class 전구와스위치 {
	static int N;
	static char[] map;
	static char[] map2;
	static char[] answer;
	static int cnt;
	static int cnt2;
	static boolean no;
	static boolean no2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = br.readLine().toCharArray();
		map2  = Arrays.copyOf(map, map.length);
		answer = br.readLine().toCharArray();
		cnt = 0;
		cnt2 = 1;

		map2[0] =  map2[0] == '0'?'1':'0';
		map2[1] =  map2[1] == '0'?'1':'0';
		
		
		for(int i = 1; i < N-1; i++) {

			if(map[i-1] != answer[i-1]) {
				map[i-1] = map[i-1] == '0'?'1':'0';
				map[i] = map[i] == '0'?'1':'0';
				map[i+1] = map[i+1] == '0'?'1':'0';
				cnt++;
			} 
			
			if(map2[i-1] != answer[i-1]) {
				map2[i-1] = map2[i-1] == '0'?'1':'0';
				map2[i] = map2[i] == '0'?'1':'0';
				map2[i+1] = map2[i+1] == '0'?'1':'0';
				cnt2++;
			} 
			
		}
		
		if(map[N-1] != answer[N-1]) {
			map[N-1] = map[N-1] == '0'?'1':'0';
			map[N-2] = map[N-2] == '0'?'1':'0';
			cnt++;
		} 
		
		if(map2[N-1] != answer[N-1]) {
			map2[N-1] = map2[N-1] == '0'?'1':'0';
			map2[N-2] = map2[N-2] == '0'?'1':'0';
			cnt2++;
		} 

		for(int i = 0; i < N; i++) {
			if(map[i] != answer[i]) {
				no= true;
			} 
			if(map2[i] != answer[i]) {
				no2 = true;
			}
			if(no && no2)
				break;
		}
		
		if(no && no2) {
			System.out.println(-1);
		} else {
			if(!no && !no2) {
				System.out.println(Math.min(cnt, cnt2));
			}
			else if(no){
				System.out.println(cnt2);
			} else {
				System.out.println(cnt);
			}
		}
			

	}

}
