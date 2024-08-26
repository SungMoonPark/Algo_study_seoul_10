package baekjoon_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 단어수학 {
	static int N;
	static char[] arr;
	static char[] map;
	static String[] word;
	static boolean[] visited;
	static int max;
	static int sum;
	static char[] wordnum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Set<Character> s = new HashSet<>();
		
		word = new String[N];
		
		for(int i = 0; i < N; i++) {
			word[i] = br.readLine();
			char[] tmp = word[i].toCharArray();
			
			for(int j = 0; j < tmp.length; j++) {
				if(!s.contains(tmp[j])) {
					s.add(tmp[j]);
				}
			}
		}
		
		arr = new char[s.size()];
		map = new char[s.size()];
		visited = new boolean[s.size()];
		max = 0;
		
		int cnt = 0;
		for(char c : s) {
			arr[cnt++] = c;
		}
	
		
		check(0);
		
		System.out.println(max);
	}

	private static void check(int cnt) {
		if(cnt == arr.length) {
			int num = 9;
			Map<Character, Integer> di = new HashMap<>();
			
			for(int i = 0; i <map.length; i++) {
				di.put(map[i], num--);
			}
			sum = 0;
			
			for(int i = 0; i < word.length; i++) {
				wordnum = new char[word[i].length()];
				for(int j = 0; j < word[i].length() ; j++) {
					wordnum[j] = (char)(di.get(word[i].charAt(j))+ '0');
				}
				sum += Integer.parseInt(String.valueOf(wordnum));
			}
			
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < arr.length;i++) {
			if(visited[i] == true) continue;
			map[cnt] = arr[i];
			visited[i] = true;
			
			check(cnt+1);
			
			map[cnt] = '0';
			visited[i] = false;
		}
		
	}
	
	
}
