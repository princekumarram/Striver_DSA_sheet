import java.util.*;

public class printAlphabet {
    public static void main(String[] args) {

        String series = "";
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            series = series + c;

        }
        System.out.print(series + " ");
    }

}
