public class q19_Jump_Game {

    public static boolean canJump(int[] nums) {

        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 7, 1, 2 };

        System.out.print("Array representing maximum jump from each index: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        boolean ans = canJump(nums);

        if (ans) {
            System.out.println("It is possible to reach the last index.");
        } else {
            System.out.println("It is not possible to reach the last index.");
        }
    }
}
