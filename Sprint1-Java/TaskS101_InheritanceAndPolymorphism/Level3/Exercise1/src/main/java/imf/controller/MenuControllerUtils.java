package imf.controller;

import imf.model.Journalist;

import static imf.controller.MenuController.journalists;

public class MenuUtils {

    public boolean idFound(String id) {
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

    public Journalist findJournalist(String id) {
        Journalist journalist = null;
        for (Journalist element : journalists) {
            if (element.getId().equalsIgnoreCase(id)) {
                journalist = element;
            }
        }
        return journalist;
    }

    public static void showJournalists() {
        for (Journalist element : journalists) {
            System.out.println(element.toString());
        }
    }

}
