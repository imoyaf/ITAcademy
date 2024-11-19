package imf.view;

import java.util.Scanner;

public class MenuViewUtils {
    Scanner keyboardInput = new Scanner(System.in);

    public MenuViewUtils() {
    }

    public String enterString(String prompt) {
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }

    public void feedbackMessage(String message) {
        System.out.println(message);
    }
}
