import java.io.*;
import java.util.*;

public class Main {

    static HashMap<String, Integer> dict;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            if (temp.length() >= m) {
                dict.put(temp, dict.getOrDefault(temp, 0) + 1);
            }
        }
        List<String> words = new ArrayList<>(dict.keySet());
        Collections.sort(words, (String o1, String o2) -> {
            if (dict.get(o1) > dict.get(o2)) {
                return -1;
            } else if (dict.get(o1) < dict.get(o2)) {
                return 1;
            } else {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return 1;
                } else {
                    int index = 0;
                    while (index < o1.length() && o1.charAt(index) == o2.charAt(index)) {
                        index++;
                    }
                    return o1.charAt(index) - o2.charAt(index);
                }
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s).append('\n');
        }
        System.out.print(sb.toString());
    }
}
