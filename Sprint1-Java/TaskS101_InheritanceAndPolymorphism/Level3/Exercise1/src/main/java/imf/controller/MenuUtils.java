package imf.controller;

import imf.model.Journalist;

public class MenuUtils {

    public static boolean idFound(String id) {
        boolean idFound = false;
        int i = 0;
        while (i < journalists.size() && !idFound) {
            if (journalists.get(i).getId().equalsIgnoreCase(id)) {
                idFound = true;
            }
            i++;
        }
        return idFound;
    }

    public static Journalist findJournalist(String id) {
        Journalist journalist = null;
        for (Journalist element : journalists) {
            if (element.getId().equalsIgnoreCase(id)) {
                journalist = element;
            }
        }
        return journalist;
    }

}
