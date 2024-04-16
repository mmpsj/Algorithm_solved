import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        star(arr, n, 0, 0, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void star(char[][] arr, int n, int x, int y, boolean blank) {
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        int size = n / 3;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                if (i == x + size && j == y + size) {
                    star(arr, size, i, j, true);
                } else {
                    star(arr, size, i, j, false);
                }
            }
        }
    }
}
