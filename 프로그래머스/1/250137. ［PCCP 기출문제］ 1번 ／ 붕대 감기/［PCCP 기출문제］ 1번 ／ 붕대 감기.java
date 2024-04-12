class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int hp = health;
        int atk_time = 0;
        for (int[] temp : attacks) {
            int band_count = temp[0] - atk_time - 1;
            int bonus_count = band_count / bandage[0];
            hp += band_count * bandage[1];
            hp += bonus_count * bandage[2];
            hp = Math.min(hp, health);
            hp -= temp[1];
            atk_time = temp[0];
            if (hp <= 0) {
                return -1;
            }
        }
        return hp;
    }
}
