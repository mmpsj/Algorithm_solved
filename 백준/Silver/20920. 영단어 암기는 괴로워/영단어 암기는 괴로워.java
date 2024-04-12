import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
    int count;
    int len;
    String word;

    public Word(String word) {
        this.word = word;
        len = word.length();
        count = 1;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(Word w) {
        if (count > w.count) {
            return -1;
        } else if (count < w.count) {
            return 1;
        } else {
            if (len == w.len) {
                return word.compareTo(w.word);
            } else {
                return w.len - len;
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Word> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;
            if (map.containsKey(str)) {
                map.get(str).addCount();
            } else {
                map.put(str, new Word(str));
            }
        }
        Set<Word> set = new TreeSet<>(map.values());
        Iterator<Word> it = set.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next().word).append('\n');
        }
        System.out.print(sb.toString());
    }
}