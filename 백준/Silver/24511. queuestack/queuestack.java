import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st1.nextToken()) == 0) {
                q.addFirst(Integer.parseInt(st2.nextToken()));
            } else {
                st2.nextToken();
            }
        }
        int m = Integer.parseInt(br.readLine());
        st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st1.nextToken());
            q.addLast(num);
            sb.append(q.removeFirst()).append(" ");
        }
        System.out.print(sb.toString());
    }
}