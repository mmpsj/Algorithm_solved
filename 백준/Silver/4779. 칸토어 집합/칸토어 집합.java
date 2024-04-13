import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int n;
        String temp;
        while (true) {
            temp = br.readLine();
            if (temp == null || temp.isBlank()) break;
            n = Integer.parseInt(temp);
            sb = new StringBuilder();
            cantor(true, (int) Math.pow(3, n), sb);
            System.out.println(sb);
        }
    }

    public static void cantor(boolean print, int len, StringBuilder sb) {
        if (len < 3) {
            sb.append((print)? "-" : " ");
        } else {
            if (print) {
                cantor(true, len / 3, sb);
                cantor(false, len / 3, sb);
                cantor(true, len / 3, sb);
            } else {
                cantor(false, len / 3, sb);
                cantor(false, len / 3, sb);
                cantor(false, len / 3, sb);
            }
        }
    }
}
