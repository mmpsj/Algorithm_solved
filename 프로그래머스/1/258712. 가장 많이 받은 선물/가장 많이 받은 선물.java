import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        int[] gift_amount = new int[len];
        int[][] log = new int[len][len];
        Map<String, Integer> friend_idx = new HashMap<>();
        for (int i = 0; i < len; i++) {
            friend_idx.put(friends[i], i);
        }
        StringTokenizer st;
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            String fr1 = st.nextToken();
            String fr2 = st.nextToken();
            gift_amount[friend_idx.get(fr1)]++;
            gift_amount[friend_idx.get(fr2)]--;
            log[friend_idx.get(fr1)][friend_idx.get(fr2)]++;
        }
        int answer = 0;
        for (int i = 0; i < len; i++) {
            int gift_count = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                if (log[i][j] > log[j][i]) gift_count++;
                else if (log[i][j] == log[j][i] && gift_amount[i] > gift_amount[j]) gift_count++;
            }
            answer = Math.max(answer, gift_count);
        }
        return answer;
    }
}