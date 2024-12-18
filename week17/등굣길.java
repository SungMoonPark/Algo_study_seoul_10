import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        int[][] map = new int[n+1][m+1];
        
        for(int i = 0; i < puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = 1;
        }
        
        dp[1][1] = 1;
        
        for(int i =1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(map[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] += (dp[i-1][j] + dp[i][j-1])%1000000007;
            }
        }
        
        answer = dp[n][m];
        //System.out.println(Arrays.deepToString(dp));
        return answer;       
        
    }
    
}
