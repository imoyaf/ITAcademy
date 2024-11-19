package imf.view;

import java.util.Scanner;

public class MenuView {
    Scanner keyboardInput = new Scanner(System.in);

    public MenuView() {
    }

    public byte userOption(String menu) {
        System.out.println(menu);
        return keyboardInput.nextByte();
    }
}
