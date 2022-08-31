import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, K;
    private static int[] digs;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        digs = new int[N];
        for(int i = 0; i < N; i++){
            digs[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(digs));
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N - K + 1; i++){
            int sum = 0;
            for(int j = i; j < i+K; j++){
                sum += digs[j];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
