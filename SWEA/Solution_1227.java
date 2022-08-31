import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] maze;
    private static boolean[][] isVisited;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int tc = 0; tc < 10; tc++){
            maze = new int[100][100];
            isVisited = new boolean[100][100];
            int n = Integer.parseInt(bf.readLine());
            result = 0;
            for(int i = 0; i < 100; i++){
                String s = bf.readLine();
                for(int j = 0; j < 100; j++){
                    maze[i][j] = s.charAt(j) - '0';
                }
            }
            dfs();
            sb.append("#").append(n).append(" ").append(result).append("\n");
//            for(int[] i : maze) System.out.println(Arrays.toString(i));

        }
        System.out.print(sb.toString());
    }
    private static void dfs(){
        Stack<Node> stack = new Stack<>();
        Node node = new Node(1, 1);
        stack.add(node);
        isVisited[1][1] = true;
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            int x = temp.x;
            int y = temp.y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(maze[nx][ny] == 0 && !isVisited[nx][ny]){
                    stack.add(new Node(nx, ny));
                    isVisited[nx][ny] = true;
                }
                if (maze[nx][ny] == 3) {
                    result = 1;
                    return;
                }
            }
        }
    }
}
class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
