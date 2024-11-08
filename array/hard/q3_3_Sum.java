//3 Sum : Find triplets that add up to a zero

import java.util.*;

public class q3_3_Sum {

    // method 1:two pointer approach
    public static List<List<Integer>> triplet1(int n, int[] arr) {

        Set<List<Integer>> st = new HashSet<>();

        // check all possible triplts

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; i < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

    }

    // methode 2: By using Hashing approach
    public static List<List<Integer>> triplet2(int n, int[] arr) {

        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                // Calculate the 3rd element:
                int third = -(arr[i] + arr[j]);

                // find element in the set

                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(j);
            }
        }
        // store the set elements in the answer:
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;

    }

    // method 3: Optimize method
    public static List<List<Integer>> triplet3(int n, int[] arr) {

        <List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            //remove duplicates
            if(i!=0 &&arr[i]==arr[i-1]) continue;

            //moving 2 pointers:

            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=arr[i]+arr[j]+arr[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int n = arr.length;
        List<List<Integer>> ans = triplet3(n, arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

}
