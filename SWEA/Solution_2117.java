import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int[] service = new int[100];
//	private static List<int[]> homes;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int N, M;
	private static int[][] city;
	private static boolean[][] isVisited;
	private static int MAX_RESULT;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(bf.readLine());
		for(int i = 1; i < service.length; i++) {
			service[i] = i * i + (i - 1) * (i - 1);
		}
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			city = new int[N][N];
			MAX_RESULT = Integer.MIN_VALUE;
//			homes = new ArrayList<int[]>();
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j = 0; j < N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					city[i][j] = temp;
//					if(temp == 1) homes.add(new int[]{i, j});
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					isVisited = new boolean[N][N];
					search(new int[] {i,j});
				}
			}
//			while(!homes.isEmpty()) {
//				isVisited = new boolean[N][N];
//				search(homes.remove(0));
//			}
			sb.append(MAX_RESULT).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void search(int[] home) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int level = 1;
		int cnt = 0;
		int qSize = 0;
		
		if(city[home[0]][home[1]]==1) cnt += 1;
		
		queue.add(home);
		
		isVisited[home[0]][home[1]] = true;
		
		while(!queue.isEmpty()) {
			if(isLose(level, cnt)) MAX_RESULT = Math.max(cnt, MAX_RESULT);
			qSize = queue.size();
			while(qSize-- > 0) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx >= 0 && ny >= 0 && nx < N && ny < N && !isVisited[nx][ny]) {
						if(city[nx][ny]==1) cnt++;
						isVisited[nx][ny] = true;
						queue.add(new int[] {nx, ny});	
					}
				}
			}
			level+=1;
		}
	}
	private static boolean isLose(int level, int cnt) {
		if((cnt * M) >= service[level]) {
			return true;
		}
		return false;
	}
}
