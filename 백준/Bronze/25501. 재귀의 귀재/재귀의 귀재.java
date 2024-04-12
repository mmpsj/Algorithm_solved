import java.io.*;
import java.util.*;

public class Main {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt = 0;
            String str = br.readLine();
            System.out.println(isPalindrome(str, 0, str.length() - 1) + " " + cnt);
        }
    }

    public static int isPalindrome(String str, int start, int end) {
        cnt++;
        if (start >= end) return 1;
        else if (str.charAt(start) != str.charAt(end)) return 0;
        else return isPalindrome(str, start + 1, end - 1);
    }
}