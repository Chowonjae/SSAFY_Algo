import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
/*  1 0 0 0 0
    1 1 0 0 0
    1 2 1 0 0
    1 3 3 1 0
    1 4 6 4 1 */
    private static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            arr[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        System.out.println(arr[n-1][k-1]);
    }
}
