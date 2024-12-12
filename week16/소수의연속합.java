import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] visited = new boolean[N+1];
		List<Integer> li = new ArrayList<>();
		
		for(int i = 2; i <= N; i++) {
			//System.out.println(i);
			if(visited[i])
				continue;

			for(int j = i+i; j <= N; j+=i) {
				
				if(j > N)
					break;
				if(visited[j])
					continue;
				if(j%i == 0) {
					visited[j] = true;
				}
			}
			
			li.add(i);
		}
		
		
		//System.out.println(li.size());
		
		long[] map = new long[li.size()+1];
		
		long answer = 0;
		
		int tmp = 0;
		int left = 0;
		
		for(int i = 0; i < li.size();i++) {
			tmp += li.get(i);
			if(tmp == N) {
				answer++;
			}
			//System.out.println(tmp + " " + li.get(i));
			
			while(tmp >= N) {
				
				tmp-=li.get(left++);
				if(tmp == N) {
					answer++;
				}
				
			}
				
		}
		
		
		System.out.println(answer);
	}

}
