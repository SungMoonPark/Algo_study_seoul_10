import java.util.*;

// 풀이 : https://tech.kakao.com/posts/488
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map = new int[board.length+1][board[0].length+1];

        for(int i = 0; i < skill.length; i++){
            int[] idx = skill[i];
            int type = idx[0];
            int r1 = idx[1];
            int c1 = idx[2];
            int r2 = idx[3];
            int c2 = idx[4];
            int degree = idx[5];
            if(type == 1){
                map[r1][c1] -= degree;
       
                map[r1][c2+1] += degree;
              
                map[r2+1][c1] += degree;
               
                map[r2+1][c2+1] -= degree;
                
                
                    
            } else {
                map[r1][c1] += degree;
                
                map[r1][c2+1] -= degree;
                
                map[r2+1][c1] -= degree;
                
           
                map[r2+1][c2+1] += degree;
                
            }
            //System.out.println(Arrays.deepToString(map));
            
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                map[i][j+1] += map[i][j];
            }
        }
        //System.out.println(Arrays.deepToString(map));
        
        for(int j = 0; j < board[0].length; j++){
            for(int i = 0; i < board.length; i++){
                map[i+1][j] += map[i][j];
               
            }
        }
        //System.out.println(Arrays.deepToString(map));
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                //System.out.println(map[i][j]);
                if(board[i][j] + map[i][j] > 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
