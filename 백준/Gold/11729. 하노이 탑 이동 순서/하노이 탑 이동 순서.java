import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append((int)Math.pow(2, n) - 1).append("\n");
        hanoi(sb, n, '1', '2', '3');
        System.out.print(sb);
    }

    public static void hanoi(StringBuilder sb, int n, char from, char temp, char to) {
        if (n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        hanoi(sb, n - 1, from, to, temp);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(sb, n - 1, temp, from, to);
    }
}
