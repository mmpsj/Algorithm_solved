import java.io.*;

public class Main {

    static int n;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = 0;
        dfs(0);
        System.out.println(result);
    }

    public static void dfs(int i) {
        if (i == n) {
            result++;
            return;
        }
        for (int j = 0; j < n; j++) {
            arr[i] = j;
            if (!promising(i)) continue;
            dfs(i + 1);
        }
    }

    public static boolean promising(int i) {
        for (int j = 0; j < i; j++) {
            if (arr[i] == arr[j] || Math.abs(arr[i] - arr[j]) == i - j) // i보다 위의 행들에 나랑 같은 열 혹은 대각선인 애들이 있는가
                return false;
        }
        return true;
    }
}
