package recursion;

import java.util.Arrays;

/**
 * Created by mwypych on 01.06.17.
 */
public class ListUtility {

    public static String showList(Integer[] number) {
        if (number.length == 0) {
            return "";
        }
        return head(number) + showList(tail(number));
    }

    public static <T> T head(T[] list) {
        return list[0];
    }

    public static <T> T[] tail(T[] list) {
        return Arrays.copyOfRange(list, 1, list.length);
    }

}
