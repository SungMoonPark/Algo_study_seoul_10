import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long answer;
	static int n;
	public static void main(String[] args) {

		long[][] dp = new long[31][31];

		
		
		for(int i = 0; i <=30; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
			
		}
		
		
	
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();

			if(n==0)
				break;		
			System.out.println(dp[n][n]);
		}
	}
}


