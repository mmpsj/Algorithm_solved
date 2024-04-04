import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int res = 1;
        int k_temp = k;
        for (int i = 0; i < k_temp; i++, n--) {
            res *= n;
        }
        for (int i = 0; i < k_temp; i++, k--) {
            res /= k;
        }
        System.out.print(res);
    }
}