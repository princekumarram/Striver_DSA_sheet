import java.util.*;

public class q7_Assign_Cookies {
    public static int findContentChildren(int[] greed, int[] cookieSize) {
        int n = greed.length;
        int m = cookieSize.length;

        Arrays.sort(greed);
        Arrays.sort(cookieSize);

        int l = 0;
        int r = 0;

        while (l < m && r < n) {

            if (greed[r] <= cookieSize[l]) {
                r++;
            }
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] greed = { 1, 5, 3, 3, 4 };
        int[] cookieSize = { 4, 2, 1, 2, 1, 3 };

        System.out.print("Array Representing Greed: ");
        for (int i = 0; i < greed.length; i++) {
            System.out.print(greed[i] + " ");
        }
        System.out.println();

        System.out.print("Array Representing Cookie Size: ");
        for (int i = 0; i < cookieSize.length; i++) {
            System.out.print(cookieSize[i] + " ");
        }

        int ans = findContentChildren(greed, cookieSize);

        System.out.println();
        System.out.println("No. of kids assigned cookies " + ans);// 3
        System.out.println();
    }

}
