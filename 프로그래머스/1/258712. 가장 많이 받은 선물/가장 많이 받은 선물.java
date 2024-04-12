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
        int[] will = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (log[i][j] > log[j][i]) {
                    will[i]++;
                } else if (log[i][j] < log[j][i]) {
                    will[j]++;
                } else {
                    if (gift_amount[i] > gift_amount[j]) {
                        will[i]++;
                    } else if (gift_amount[i] < gift_amount[j]) {
                        will[j]++;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (will[i] > max) max = will[i];
        }
        return max;
    }
}