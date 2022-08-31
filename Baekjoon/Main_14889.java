import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889 {
	static int[][] member;
	static int N, RESULT_MIN = Integer.MAX_VALUE, star, link;
	static int[] result, data, unresult;
	static boolean[] isVisited;
	static int[] temp1, temp2;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		member = new int[N+1][N+1];
		result = new int[N/2];
		isVisited = new boolean[N];
		temp1 = new int[2];
		temp2 = new int[2];
		
		data = new int[N];
		for(int i = 0; i < N; i++) {
			data[i] = i+1;
		}
				
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j = 1; j <= N; j++) {
				member[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int[] i : member) System.out.println(Arrays.toString(i));
		comb(0, 0);
		System.out.println(RESULT_MIN);
	}
	
	static void comb(int cnt, int start) {
		if(cnt == N/2) {
			star = 0;
			link = 0;
//			RESULT_MIN = Integer.MAX_VALUE;
			unresult = new int[N/2];
			int index = 0;
			for(int i = 0; i < N; i++) {
				if(!isVisited[i]) unresult[index++] = data[i];
			}
//			System.out.println(Arrays.toString(result));
//			System.out.println(Arrays.toString(unresult));
			comb2(0, 0);
			return;
		}
		
		for(int i = start; i < N; i++) {
			isVisited[i] = true;
			result[cnt] = data[i];
			comb(cnt+1, i+1);
			isVisited[i] = false;
		}
	}
	
	static void comb2(int cnt, int start) {
		if(cnt == 2) {
			System.out.println(temp1[0] + " " + temp1[1]);
			System.out.println(temp2[0] + " " + temp2[1]);
//			System.out.println(member[temp1[0]][temp1[1]] + " " + member[temp1[1]][temp1[0]]);
			star += (member[temp1[0]][temp1[1]] + member[temp1[1]][temp1[0]]);
			link += (member[temp2[0]][temp2[1]] + member[temp2[1]][temp2[0]]);
			System.out.println(star + " " + link);
			System.out.println("-----------");
			RESULT_MIN = Math.min(RESULT_MIN, Math.abs(star-link));
			return;
		}
		
		for(int i = start; i < N/2; i++) {
			temp1[cnt] = result[i];
			temp2[cnt] = unresult[i];
			comb2(cnt+1, i+1);
		}
	}
}
