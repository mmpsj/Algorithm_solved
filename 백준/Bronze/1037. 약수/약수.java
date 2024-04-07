import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 2, min = 1000000;
        for (int i = 0; i < c; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > max) max = n;
            if (n < min) min = n;
        }
        System.out.print(max * min);
    }
}
