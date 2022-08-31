import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	static int[][] pan = new int[4][4];
	static HashSet<Integer> set;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
            set = new HashSet<>();
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				for(int j = 0; j < 4; j++) {
					pan[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					dfs(i, j, 0, pan[i][j]);
				}
			}
//			for(String s : set) System.out.println(s);
			sb.append(set.size()).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static void dfs(int a, int b, int cnt, int nums) {		
		if(cnt == 6) {
			set.add(nums);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = a + dx[i];
			int ny = b + dy[i];
			if(nx>=0 && ny>=0 && nx<4 && ny<4) {
				dfs(nx, ny, cnt+1, nums * 10 + pan[nx][ny]);
			}
		}
	}
}
