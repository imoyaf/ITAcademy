package imf.view;

import java.util.Scanner;

import static imf.controller.MenuController.*;

public class MenuView {
    public static Scanner keyboardInput = new Scanner(System.in);
    String menu = "------ MENU ------\n"
            + "1.- Enter journalist\n"
            + "2.- Delete journalist\n"
            + "3.- Enter news item for a journalist\n"
            + "4.- Delete news item\n"
            + "5.- Show all news items for a journalist\n"
            + "6.- Calculate news rating\n"
            + "7.- Calculate news price\n"
            + "8.- Exit";
    String sportMenu = "What sport is the news item about?\n" +
            "1. Football\n" +
            "2. Basketball\n" +
            "3. Tennis\n" +
            "4. Formula 1\n" +
            "5. Motocross\n");
    int option;
    String response = "";

    public MenuView() {}

    public int userOption() {
        System.out.println(menu);
        option = keyboardInput.nextInt();
        return option;
    }

    public boolean optionManager() {
        boolean exit = false;
        switch(userOption()) {
            case 1:
                response = enterJournalist();
                break;
            case 2:
                response = deleteJournalist();
                break;
            case 3:
                response = assignNews();
                break;
            case 4:
                response = deleteNews();
                break;
            case 5:
                response = findJournalistNews();
                break;
            case 6:
                response = newsRating();
                break;
            case 7:
                response = newsPrice();
                break;
            case 8:
                response = "Thank you for using the news manager\n";
                break;
            default:
                System.out.println("Please choose a correct option");
        }
        return exit;
    }

    public static byte sportOptionManager() {
        byte sport;
        System.out.println("sportMenu");
        sport = keyboardInput.nextByte();
        keyboardInput.nextLine();

        return sport;
    }

    public static String enterString(String prompt) {
        System.out.println(prompt);
        String input = keyboardInput.nextLine();
        return input;
    }

    public static void feedbackMessage(String message) {
        System.out.println(message);
    }

    public void run() {
        boolean exit;
        do {
            exit = optionManager();
        } while (!exit);
    }
}
