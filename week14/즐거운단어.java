import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static long answer;
	static char[] map;
	static String alp = "BCDFGHJKMNPQRSTVWXYZ";
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		map =  br.readLine().toCharArray();
	
		back(0,false,0,0,0,0,0);
		System.out.println(answer);
	}
	
	static void back(int cnt, boolean l, int l_cnt, int ja, int mo, int ja_cnt, int mo_cnt) {
		
		//System.out.println(cnt + " " + l_cnt + " " + ja + " " + mo + " " +ja_cnt + " " + mo_cnt);
		if(ja ==3 || mo ==3)
			return;
		
		if(cnt == map.length) {
			
			if(l==false)
				return;
			
			//System.out.println(cnt + " " + l_cnt + " " + ja + " " + mo + " " +ja_cnt + " " + mo_cnt);
			
			if(l_cnt > 0 && ja_cnt == 0 && mo_cnt == 0) {
				answer+=1;
				return;
			}
			
			if(ja_cnt > 0 && mo_cnt > 0) {
				answer += (Math.pow(alp.length(),ja_cnt) * (Math.pow(5, mo_cnt)));
			}
			
			else if(ja_cnt == 0) {
				
				answer +=(Math.pow(5, mo_cnt));
				
			}
			else {
				answer += Math.pow(alp.length(),ja_cnt);
			}
			
			
			//System.out.println(answer);
			
			
			return;
		}
		
		
		if(map[cnt] == 'L')
			l = true;
		
		if(map[cnt] != '_') {
			
			if(check(map[cnt])) {
				back(cnt+1,l,l_cnt, 0, mo+1,ja_cnt,mo_cnt); 
			} else {
				back(cnt+1,l, l_cnt, ja+1, 0,ja_cnt, mo_cnt); 
			}
			
		}	
		

		else {	
			back(cnt+1,l,l_cnt, 0, mo+1,ja_cnt,mo_cnt+1); 
			back(cnt+1,l,l_cnt, ja+1, 0,ja_cnt+1, mo_cnt); 
			back(cnt+1,true,l_cnt+1, ja+1, 0,ja_cnt, mo_cnt); 
		}

		
		
		
	}
	
	static boolean check(char w) {
		return w == 'A' || w == 'E' || w == 'I' || w == 'O' || w =='U'; 
	}

}
