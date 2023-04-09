package utils;

import java.util.Collections;
import java.util.List;

public class ListSorter {

    public static List<String> sortAZ(List<String> list) {
        Collections.sort(list);
        return list;
    }
    public static List<String> sortZA(List<String> list) {
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
}
