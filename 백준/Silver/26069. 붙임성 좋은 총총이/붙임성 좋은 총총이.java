import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Map<String, Boolean> dance = new HashMap<>();
            dance.put("ChongChong", true);
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();
                if (dance.get(p1) == null) {
                    dance.put(p1, false);
                }
                if (dance.get(p2) == null) {
                    dance.put(p2, false);
                }
                if (dance.get(p1) || dance.get(p2)) {
                    dance.replace(p1, true);
                    dance.replace(p2, true);
                }
            }
            int count = 0;
            for (boolean b : dance.values()) {
                if (b) count++;
            }
            System.out.print(count);
            br.close();
        }
}
