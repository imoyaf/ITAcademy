package imf.controller;

import imf.model.*;

import java.util.ArrayList;

import static imf.controller.MenuUtils.findJournalist;
import static imf.controller.MenuUtils.idFound;
import static imf.view.MenuView.keyboardInput;

public class MenuController {
    public static ArrayList<Journalist> journalists = new ArrayList<>();
    public static String enterJournalist() {
        String message;
        String name;
        String id;
        System.out.println("Enter the name of the journalist");
        name = keyboardInput.nextLine();
        System.out.println("Enter id number");
        id = keyboardInput.nextLine();
        if (idFound(id)) {
            message = "This id is already in use\n";
            showJournalists();
        } else {
            Journalist journalist = new Journalist(name, id);
            journalists.add(journalist);
            message = "\nJournalist added successfully\n";
            showJournalists();
        }
        return message;
    }

    public static String deleteJournalist() {
        String id;
        String message;
        System.out.println("Enter id number");
        id = keyboardInput.nextLine();
        if (!idFound(id)) {
            message = "\nId not found\n";
        } else {
            journalists.remove(findJournalist(id));
            message = "\nJournalist deleted successfully\n";
        }
        return message;
    }

    public static String assignNews() {
        String id;
        String headline;
        int sport;
        String response = "";
        System.out.println("Type the id of the journalist that will be assigned the news item: ");
        id = keyboardInput.nextLine();
        if (!idFound(id)) {
            response = "Id not found in the system";
        } else {
            System.out.println("What sport is the news item about?\n" +
                    "1. Football\n" +
                    "2. Basketball\n" +
                    "3. Tennis\n" +
                    "4. Formula 1\n" +
                    "5. Motocross\n");
            sport = keyboardInput.nextInt();
            keyboardInput.nextLine();
            System.out.println("News headline:");
            headline = keyboardInput.nextLine();
            switch (sport) {
                case 1:
                    response = assignFootballNews(id, headline);
                    break;
                case 2:
                    response = assignBasketNews(id, headline);
                    break;
                case 3:
                    response = assignTennisNews(id, headline);
                    break;
                case 4:
                    response = assignFormula1News(id, headline);
                    break;
                case 5:
                    response = assignMotocrossNews(id, headline);
            }
        }
        return response;
    }

    public static String assignFootballNews(String id, String headline) {
        String message = "";
        String competition;
        String club;
        String player;

        System.out.println("Competition: ");
        competition = keyboardInput.nextLine();
        System.out.println("Club: ");
        club = keyboardInput.nextLine();
        System.out.println("Player: ");
        player = keyboardInput.nextLine();
        Journalist journalist = findJournalist(id);

        FootballNews footballNews = new FootballNews(headline, journalist, competition, club, player);
        journalist.getNews().add(footballNews);

        return message;
    }

    public static String assignBasketNews(String id, String headline) {
        String message = "";
        String competition;
        String club;

        System.out.println("Competition: ");
        competition = keyboardInput.nextLine();
        System.out.println("Club: ");
        club = keyboardInput.nextLine();
        Journalist journalist = findJournalist(id);

        BasketballNews basketballNews = new BasketballNews(headline, journalist, competition, club);
        journalist.getNews().add(basketballNews);

        return message;
    }

    public static String assignTennisNews(String id, String headline) {
        String message = "";
        String competition;
        String player;

        System.out.println("Competition: ");
        competition = keyboardInput.nextLine();
        System.out.println("Player: ");
        player = keyboardInput.nextLine();
        Journalist journalist = findJournalist(id);

        TennisNews tennisNews = new TennisNews(headline, journalist, competition, player);
        journalist.getNews().add(tennisNews);

        return message;
    }

    public static String assignFormula1News(String id, String headline) {
        String message = "";
        String team;

        System.out.println("Team: ");
        team = keyboardInput.nextLine();
        Journalist journalist = findJournalist(id);

        F1News f1News = new F1News(headline, journalist, team);
        journalist.getNews().add(f1News);

        return message;
    }

    public static String assignMotocrossNews(String id, String headline) {
        String message = "";
        String equip;

        System.out.println("Equip: ");
        equip = keyboardInput.nextLine();
        Journalist journalist = findJournalist(id);

        MotocrossNews motocrossNews = new MotocrossNews(headline, journalist, equip);
        journalist.getNews().add(motocrossNews);

        return message;
    }

    public static String deleteNews() {
        String message = "Headline not found";
        String id;
        String headline;
        System.out.println("Enter the journalist id to delete the news item: ");
        id = keyboardInput.nextLine();
        if (!idFound(id)) {
            System.out.println("Id not found");
        } else {
            System.out.println("News headline: ");
            headline = keyboardInput.nextLine();
            for (int i = 0; i < findJournalist(id).getNews().size(); i++) {
                if (findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    findJournalist(id).getNews().remove(i);
                    message = "News item deleted successfully";
                }
            }
        }
        return message;
    }

    public static String findJournalistNews() {
        String message;
        String id;
        System.out.println("Enter the journalist id to show their news: ");
        id = keyboardInput.nextLine();
        if (!idFound(id)) {
            message = "Id not found";
        } else {
            message = findJournalist(id).getNews().toString();
        }
        return message;
    }

    public static String newsRating() {
        String message = "Headline not found";
        String id;
        String headline;
        System.out.println("Enter the journalist id for the news item: ");
        id = keyboardInput.nextLine();
        if (!idFound(id)) {
            message = "Id not found";
        } else {
            System.out.println("News headline: ");
            headline = keyboardInput.nextLine();
            for (int i = 0; i < findJournalist(id).getNews().size(); i++) {
                if (findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    message = "News rating: " + findJournalist(id).getNews().get(i).calculateNewsRating();
                }
            }
        }
        return message;
    }

    public static String newsPrice() {
        String message = "Headline not found";
        String id;
        String headline;
        System.out.println("Enter the journalist id for the news item: ");
        id = keyboardInput.nextLine();
        if (!idFound(id)) {
            message = "Id not found";
        } else {
            System.out.println("News headline: ");
            headline = keyboardInput.nextLine();
            for (int i = 0; i < findJournalist(id).getNews().size(); i++) {
                if (findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    message = "News item price: " + findJournalist(id).getNews().get(i).calculateArticlePrice();
                }
            }
        }
        return message;
    }

    public static void showJournalists() {
        for (Journalist element : journalists) {
            System.out.println(element.toString());
        }
    }

}
