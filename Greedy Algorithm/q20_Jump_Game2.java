
public class q20_Jump_Game2 {

    public int jump(int[] nums) {

        int maxIndex = 0;
        int count = 0;
        int currentEnd = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > maxIndex) {
                return -1;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);

            if (i == currentEnd) {
                count++;
                currentEnd = maxIndex;

                // If currentEnd reaches or exceeds the last index, we can stop

                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };

        q20_Jump_Game2 solution = new q20_Jump_Game2();
        int result = solution.jump(nums);

        System.out.println(result);
    }

}
