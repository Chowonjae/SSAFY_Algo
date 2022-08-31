import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	static int[] p;
	static Edge[] edgeAarray;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ss = new StringTokenizer(bf.readLine(), " ");
		int V = Integer.parseInt(ss.nextToken());
		int E = Integer.parseInt(ss.nextToken());
		
		p = new int[V+1];
		for(int i = 1; i <= V; i++) {
			p[i] = i;
		}
		edgeAarray = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			ss = new StringTokenizer(bf.readLine());
			edgeAarray[i] = new Edge(Integer.parseInt(ss.nextToken()), Integer.parseInt(ss.nextToken()), Integer.parseInt(ss.nextToken()));
		}
		
		Arrays.sort(edgeAarray);
		
		int result = 0;
		int cnt = 0;
		for(Edge edge : edgeAarray) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++cnt >= V-1) break;
			}
		}
		System.out.println(result);
	}
	
	private static int find(int index) {
		if(p[index] == index) return index;
		return p[index] = find(p[index]); 
	}
	
	private static boolean union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);
		if(root1 == root2) return false;
		if(root1 > root2) p[root2] = root1;
		else p[root1] = root2; 
		return true;
	}
}
