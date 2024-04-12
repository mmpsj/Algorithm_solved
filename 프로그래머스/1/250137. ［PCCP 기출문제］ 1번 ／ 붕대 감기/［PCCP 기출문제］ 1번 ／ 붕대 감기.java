class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int cur_time = 0;
        for (int i = 0; i < attacks.length; i++) {
            if (hp < health) {
                for (int j = 1; j < attacks[i][0] - cur_time; j++) {
                    hp += bandage[1];
                    if (j % bandage[0] == 0) {
                        hp += bandage[2];
                    }
                    if (hp > health) {
                        hp = health;
                        break;
                    }
                }
            }
            hp -= attacks[i][1];
            if (hp <= 0) break;
            cur_time = attacks[i][0];
        }
        return (hp <= 0) ? -1 : hp;
    }
}