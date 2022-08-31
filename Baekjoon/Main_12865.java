import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] backPack = new int[N+1][2];
		int[][] dp = new int[N+1][K+1];
		// 무게, 가치
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			backPack[i][0] = Integer.parseInt(st.nextToken());
			backPack[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(backPack, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=backPack[i][0])
					dp[i][j] = Math.max(dp[i-1][j-backPack[i][0]] + backPack[i][1], dp[i-1][j]);
			}
		}
		System.out.println(dp[N][K]);
	}
}
