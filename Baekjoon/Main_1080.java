import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
	
	static int n,m;
	static int arrN[][],arrM[][];
	
	public static boolean flip(int startA, int startB) { 
		// arrN 과 arrM이 같지 않을때 뒤집을 함수
		
		if(startA > n || startB+3 > m) { 
			return false; 
			} 
		
		for(int i = startA; i <= startA + 2; i++) { 			
			for(int j = startB; j <= startB + 2; j++) {
				arrN[i][j]= 1-(arrN[i][j]);					
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arrN = new int[n][m];
		arrM = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {				
				arrN[i][j] =row.charAt(j)-'0';
				
			}
		}
		for(int i = 0; i < n; i++) {
			String row = br.readLine();
			for(int j = 0; j < m; j++) {				
				arrM[i][j] =row.charAt(j)-'0';
				
			}
		}
		
		int count = 0;
		loop : for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				
				if(arrN[i][j] != arrM[i][j]) {
					if(flip(i,j)) {
						count++;
					}else {
						count = -1;
						break loop;					
					}
				}
				
			}
		}
		
		System.out.println(count);
		br.close();	
}
  
	}
출처: https://seeminglyjs.tistory.com/205 [Seemingly Online:티스토리]
