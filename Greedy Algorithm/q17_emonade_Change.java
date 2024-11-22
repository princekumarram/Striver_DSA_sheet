import java.util.*;

public class q17_emonade_Change {

    public static boolean lemonadeChange(List<Integer> bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i) == 5) {
                five++;
            } else if (bills.get(i) == 10) {
                if (five > 0) {
                    five--;
                    ten++;

                } else
                    return false;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> bills = new ArrayList<>();

        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);

        System.out.print("Queues of customers: ");
        for (int bill : bills) {
            System.out.print(bill + " ");
        }
        System.out.println();

        boolean ans = lemonadeChange(bills);
        if (ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");
    }
}
