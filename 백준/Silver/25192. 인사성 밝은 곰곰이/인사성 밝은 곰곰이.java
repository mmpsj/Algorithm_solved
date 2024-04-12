import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Map<String, Character> member = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < n; i++) {
                String temp = br.readLine();
                if (temp.compareTo("ENTER") == 0) {
                    member.clear();
                } else {
                    if (member.get(temp) == null) {
                        member.put(temp, ' ');
                        count++;
                    }
                }
            }
            System.out.print(count);
        }
}
