import java.util.*;

public class q3_Maximum_length_chain_of_pairs {

    public static void main(String[] args) {
        // tc-o(nlog(n))
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40, }, { 50, 90 } };

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int chainEnd = pairs[0][1];// last selected pairs end

        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("max length of chain = " + chainLen);// 3
    }

}
