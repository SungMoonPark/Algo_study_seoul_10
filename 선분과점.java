package baekjoon_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 선분과점 {
	
	static double[] A;
	static double[] B;
	static double[] C;
	static double answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new double[3];
		B = new double[3];
		C = new double[3];
		
		for(int i = 0; i < 3; i++) {
			A[i] = Double.parseDouble(st.nextToken());
		}
		for(int i = 0; i < 3; i++) {
			B[i] = Double.parseDouble(st.nextToken());
		}
		for(int i = 0; i < 3; i++) {
			C[i] =Double.parseDouble(st.nextToken());
		}
		
		answer = Double.MAX_VALUE;
		
		while(true) {
			double mx = (A[0]+B[0])/2;
			double my = (A[1] + B[1])/2;
			double mz = (A[2] + B[2])/2;

			double left = Math.sqrt(Math.pow(A[0] - C[0], 2) + Math.pow(A[1] - C[1], 2) + Math.pow(A[2] - C[2], 2));
			double right = Math.sqrt(Math.pow(B[0] - C[0], 2) + Math.pow(B[1] - C[1], 2) + Math.pow(B[2] - C[2], 2));
			double mid = Math.sqrt(Math.pow(mx - C[0], 2) + Math.pow(my - C[1], 2) + Math.pow(mz - C[2], 2));
			double ab = Math.sqrt(Math.pow(A[0] - B[0], 2) + Math.pow(A[1] - B[1], 2) + Math.pow(A[2] - B[2], 2));
			
			if(-1*1e-6 <= ab  &&  ab <= 1e-6) {
				break;
			}
			
			answer = Math.min(answer, mid);
			
			if(left > right) {
				A[0] = mx;
				A[1] = my;
				A[2] = mz;
			}
			else {
				B[0] = mx;
				B[1] = my;
				B[2] = mz;
			}
		
		}
		System.out.printf("%.10f", answer);

		
	}

}
