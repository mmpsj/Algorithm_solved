import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, min = 4000, max = -4000;
            for (int i = 0; i < n; i++) {
                int key = Integer.parseInt(br.readLine());
                num[i] = key;
                if (map.containsKey(key)) {
                    map.replace(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
                sum += key;
                min = Math.min(min, key);
                max = Math.max(max, key);
            }
            Arrays.sort(num);
            int max_count = 0;
            for (int i : num) {
                max_count = Math.max(max_count, map.get(i));
            }
            int many1 = -4001, many2 = -4001;
            for (int i : num) {
                if (map.get(i) == max_count) {
                    if (many1 == -4001) {
                        many1 = i;
                    } else if (many2 == -4001 && i != many1) {
                        many2 = i;
                    }
                }
            }
            System.out.println(Math.round((double)sum / n));
            System.out.println(num[(n - 1) / 2]);
            System.out.println((many2 == -4001)? many1 : many2);
            System.out.println(max - min);
            br.close();
        }
}
