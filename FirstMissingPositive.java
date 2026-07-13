public class FirstMissingPositive {
    public int solution(int[] nums) {
        boolean[] seen = new boolean[nums.length + 2];

        for (int num : nums) {
            if (num > 0 && num < seen.length) {
                seen[num] = true;
            }
        }

        for (int i = 1; i < seen.length; i++) {
            if (!seen[i]) {
                return i;
            }
        }

        return seen.length;
    }
}
