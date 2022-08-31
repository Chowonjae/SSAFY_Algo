import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer ss = new StringTokenizer(bf.readLine(), " ");
		
		int N = Integer.parseInt(ss.nextToken());
		int M = Integer.parseInt(ss.nextToken());
		
		p = new int[N+1];
		for(int i = 1; i <= N; i++) {
			p[i] = i;
		}
		
		int[] temp = new int[3];
		for(int i = 0; i < M; i++) {
			ss = new StringTokenizer(bf.readLine());
			temp[0] = Integer.parseInt(ss.nextToken());
			temp[1] = Integer.parseInt(ss.nextToken());
			temp[2] = Integer.parseInt(ss.nextToken());
			
			switch (temp[0]) {
			case 0:
				union(temp[1], temp[2]);
				break;

			case 1:
				if(find(temp[1])==find(temp[2])) {
					sb.append("YES").append("\n");
				}else {
					sb.append("NO").append("\n");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
	private static int find(int index) {
		if(p[index]==index) return index;
		return p[index] = find(p[index]);
	}
	private static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);
		if(root1 == root2) return;
		if(root1 > root2) p[root2] = root1;
		else p[root1] = root2; 
	}
}
