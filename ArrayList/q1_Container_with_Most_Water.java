import java.util.ArrayList;

public class q1_Container_with_Most_Water {

    // Brute Force method
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int n = height.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int wd = j - i;
                int currWatr = ht * wd;
                maxWater = Math.max(maxWater, currWatr);
            }

        }
        return maxWater;
    }

    // Two pointer Apporach

    public static int storeWater2(ArrayList<Integer> height) {
        int maxWater = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            // calculate water area
            int ht = Math.min(height.get(left), height.get(right));
            int width = right - left;
            int currWatr = ht * width;
            maxWater = Math.max(maxWater, currWatr);

            // update pointer
            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String ags[]) {
        ArrayList<Integer> height = new ArrayList<>();
        // 1 8 6 2 5 4 8 3 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));
        System.out.println(storeWater2(height));

    }

}