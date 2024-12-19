class Solution {
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0,-1,1,0};
    static boolean end;
    static int N,M;
    static int K;
    static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";

        K = k;
        end = false;
        int nr = x-1;
        int nc = y-1;
        int cnt = 0;
        // for(int d = 0; d< 4; d++) {
        //     if(end==true){
        //         break;
        //     }
 
            while(true) {
                boolean no = true;
                for(int d = 0; d < 4; d++){
            
                    nr += dr[d];
                    nc += dc[d];
                
                    if(nr >= n || nr < 0 || nc >= m || nc < 0){
                        nr-=dr[d];
                        nc-=dc[d];
                        continue;
                    }
                
                    if(Math.abs(nr -(r-1)) + Math.abs(nc-(c-1)) > K){
                        nr-=dr[d];
                        nc-=dc[d];
                        continue;
                    }
                    
                    answer+= (d==0?"d":d==1?"l":d==2?"r":"u");
                    K--;
                    no = false;

                    //System.out.println(nr + " " + nc + " " + answer + " " + cnt);
                
                    if(K==0 && nr==r-1 && nc == c-1){
                        end = true;
                        break;
                    }
                    
                    if(no==false){
                        break;
                    }

                }
                if(end==true){
                    return answer;
                }
                if(no==true){
                  return "impossible";
                }
               

 
            }
            
        }
}
