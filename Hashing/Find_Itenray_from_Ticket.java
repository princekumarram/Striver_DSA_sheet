import java.util.*;

public class Find_Itenray_from_Ticket {

    public static String getStart(HashMap<String, String> tickets) {

        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {

            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {// o(n)
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Benguluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String ans = getStart(tickets);

        System.out.print(ans);

        for (String key : tickets.keySet()) {
            System.out.print("--> " + tickets.get(ans) + " ");
            ans = tickets.get(ans);
        }
        System.out.println();
    }

}