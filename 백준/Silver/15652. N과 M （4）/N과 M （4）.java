import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int n, m;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0, -1);
        System.out.println(sb);
    }

    public static void dfs(int depth, int index) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i >= index) {
                arr[depth] = i + 1;
                dfs(depth + 1, i);
            }
        }
    }
}
