class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        if (a % 2 == 1) {
            if (b % 2 == 1) {
                answer += Math.pow(a, 2) + Math.pow(b, 2);
            } else {
                answer += 2 * (a + b);
            }
        } else if (b % 2 == 1) {
            answer += 2 * (a + b);
        } else {
            answer += Math.abs(a - b);
        }
        return (int)answer;
    }
}