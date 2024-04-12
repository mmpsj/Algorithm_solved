import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] count = new int[8001];
            int sum = 0, min = 4000, max = -4000;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                count[4000 + num]++;
                sum += num;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            int mid = 4001;
            int cnt = 0;
            int many = 0;
            int max_cnt = 0;
            boolean cnt_check = false;
            for (int i = min + 4000; i < max + 4001; i++) {
                if (count[i] > 0) {
                    cnt += count[i];
                    if (mid == 4001 && cnt > n / 2) {
                        mid = i - 4000;
                    }
                    if (count[i] > max_cnt) {
                        max_cnt = count[i];
                        many = i - 4000;
                        cnt_check = true;
                    } else if (count[i] == max_cnt && cnt_check) {
                        many = i - 4000;
                        cnt_check = false;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Math.round((double)sum / n)).append('\n').append(mid).append('\n').append(many).append('\n').append(max - min);
            System.out.print(sb.toString());
            br.close();
        }
}
