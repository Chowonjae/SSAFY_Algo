import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_9372 {
	static int[] p;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			p = new int[N+1];
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
				cnt++;
				if(cnt == N-1) break;
			}
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	static int find(int index) {
		if(p[index] == index) return index;
		return p[index] = find(p[index]);
	}
	static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);
		if(root1 == root2) return;
		if(root1 > root2) p[root2] = root1;
		else p[root1] = root2;
	}
}
