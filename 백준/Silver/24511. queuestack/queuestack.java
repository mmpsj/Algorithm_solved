import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] qs = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            qs[i] = Integer.parseInt(st.nextToken());
        }
        int[] c = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (qs[i] == 0) {
                q.add(c[i]);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.add(num);
            sb.append(q.remove()).append(" ");
        }
        System.out.print(sb.toString());
    }
}