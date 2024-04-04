import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0 || n == 1) {
            System.out.println(1);
            return;
        }
        int res = n;
        for (n = n - 1; n > 1; n--) {
            res *= n;
        }
        System.out.print(res);
    }
}