import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        int[][] log = new int[len][len];
        Map<String, Integer> friend_idx = new HashMap<>();
        for (int i = 0; i < len; i++) {
            friend_idx.put(friends[i], i);
        }
        StringTokenizer st;
        for (int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            log[friend_idx.get(st.nextToken())][friend_idx.get(st.nextToken())] += 1;
        }
        int[] will = new int[len];
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (log[i][j] > log[j][i]) {
                    will[i] += 1;
                } else if (log[i][j] < log[j][i]) {
                    will[j] += 1;
                } else {
                    if (gift_amount(log, i, len) > gift_amount(log, j, len)) {
                        will[i] += 1;
                    } else if (gift_amount(log, i, len) < gift_amount(log, j, len)) {
                        will[j] += 1;
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
    
    public int gift_amount(int[][] log, int i, int len) {
        int sum = 0;
        for (int j = 0; j < len; j++) {
            sum += log[i][j];
            sum -= log[j][i];
        }
        return sum;
    }
}