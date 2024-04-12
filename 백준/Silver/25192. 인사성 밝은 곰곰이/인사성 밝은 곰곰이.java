import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Set<String> member = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int i = 0; i < n; i++) {
                String temp = br.readLine();
                if (temp.equals("ENTER")) {
                    count += member.size();
                    member.clear();
                } else {
                    member.add(temp);
                }
            }
            count += member.size();
            System.out.print(count);
        }
}
