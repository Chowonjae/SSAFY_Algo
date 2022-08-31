import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T, map[][] = new int[201][201];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		for(int rc=0; rc<map.length; rc++) {
			map[rc][rc] = 2*rc;
		}
		
		for(int c=0; c<map.length; c++) {
			boolean flag = false;
			for(int r=c; r>=0; r--) {
				if(flag) {
					map[r][c] = map[c][c]-1;
					flag = false;
				}else {
					map[r][c] = map[c][c];
					flag = true;
				}
			}	
		}
		
		for(int c=0; c<map.length; c++) {
			for(int r=c; r<map.length; r++) {
				map[r][c] = map[c][r]; 
			}	
		}
		
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int x1 = Integer.parseInt(tokens.nextToken());
			int y1 = Integer.parseInt(tokens.nextToken());
			int x2 = Integer.parseInt(tokens.nextToken());
			int y2 = Integer.parseInt(tokens.nextToken());
			
			int r = Math.abs(x1-x2);
			int c = Math.abs(y1-y2);
			
			System.out.println("#"+t+" "+map[r][c]);
		}
		
	}
 
	static String src =
			"3\r\n" + 
			"0 0 1 0\r\n" + 
			"-1 -1 0 0\r\n" + 
			"0 0 0 2";
}
