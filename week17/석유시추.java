import java.io.*;
import java.util.*;

class Solution {
    static int n,m;

    static boolean[][] visited;
    static boolean[] rVisited;
    static int tmp;
    static Queue<int []> q;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static Map<Integer,Integer> cnt;
    static List<Integer> li;
    
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        int index = 2;
        cnt = new HashMap<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[j][i] == 1){
                    tmp = 1;       
                    land[j][i] = index;
                    q = new LinkedList<>();
                    q.add(new int[] {j,i});
                    while(!q.isEmpty()){
                        int[] idx = q.poll();
                        int r = idx[0];
                        int c = idx[1];
                            
                        //land[r][c] = index;
                      
                        for(int d = 0; d<4; d++){
                            int nr = r +dr[d];
                            int nc = c + dc[d];
                            if(check(nr,nc) || land[nr][nc] != 1)
                                continue;
                            land[nr][nc] = index;
                            tmp++;
                            q.offer(new int[] {nr,nc});
                        }
                }
                    cnt.put(index++, tmp);
                }
            }
            
        }
        
        //System.out.println(cnt);
        for(int i = 0; i < m; i++){
            tmp = 0;
            li = new LinkedList<>();
            for(int j = 0; j < n; j++){
                if(land[j][i] > 0 && !li.contains(land[j][i])){
                    li.add(land[j][i]);
                    //System.out.println(land[j][i]);
                    
                    tmp += cnt.get(land[j][i]);
                }
               //System.out.println(tmp);
                
            }
            answer = Math.max(tmp, answer);
        }
        
        
        return answer;
    }
    

    static boolean check(int r, int c){
        return r>=n || r < 0 || c>=m || c < 0;
    }
}
