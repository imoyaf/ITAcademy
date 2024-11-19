package imf.controller;

import imf.model.*;

import java.util.ArrayList;

import static imf.controller.MenuUtils.findJournalist;
import static imf.controller.MenuUtils.idFound;
import static imf.view.MenuView.*;
import static imf.view.MenuView.feedbackMessage;

public class MenuController {
    public static ArrayList<Journalist> journalists = new ArrayList<>();

    public static String enterJournalist() {
        String firstPrompt = "Enter the name of the journalist";
        String secondPrompt = "Enter id number";
        String name;
        String id;
        String response = "";

        name = enterString(firstPrompt);
        id = enterString(secondPrompt);
        if (idFound(id)) {
            response = "This id is already in use\n");
        } else {
            Journalist journalist = new Journalist(name, id);
            journalists.add(journalist);
            response = "\nJournalist added successfully\n";
        }
        showJournalists();
        return response;
    }

    public static String deleteJournalist() {
        String firstPrompt = "Enter id number";
        String id;
        String response;
        id = enterString(firstPrompt);
        if (!idFound(id)) {
            response = "\nId not found\n";
        } else {
            journalists.remove(findJournalist(id));
            response = "\nJournalist deleted successfully\n";
        }
        return response;
    }

    public static String assignNews() {
        String firstPrompt = "Type the id of the journalist that will be assigned the news item: ";
        String secondPrompt = "Enter News headline: ";
        String id;
        String headline;
        byte sport;
        String response = "Couldn't complete the news assignation";

        id = enterString(firstPrompt);
        if (!idFound(id)) {
            response = "ID not found in the system";
        } else {
            sport = sportOptionManager();
            headline = enterString(secondPrompt);
            switch (sport) {
                case (byte)1:
                    response = assignFootballNews(id, headline);
                    break;
                case (byte)2:
                    response = assignBasketNews(id, headline);
                    break;
                case (byte)3:
                    response = assignTennisNews(id, headline);
                    break;
                case (byte)4:
                    response = assignFormula1News(id, headline);
                    break;
                case (byte)5:
                    response = assignMotocrossNews(id, headline);
                    break;
                default:
                    feedbackMessage("You can only choose options 1-5");
            }
        }
        return response;
    }

    public static String assignFootballNews(String id, String headline) {
        String firstPrompt = "Enter the competition";
        String secondPrompt = "Enter the club";
        String thirdPrompt = "Enter the player";
        String competition;
        String club;
        String player;
        String response = "Football news item assigned";

        competition = enterString(firstPrompt);
        club = enterString(secondPrompt);
        player = enterString(thirdPrompt);
        Journalist journalist = findJournalist(id);

        FootballNews footballNews = new FootballNews(headline, journalist, competition, club, player);
        journalist.getNews().add(footballNews);

        return response;
    }

    public static String assignBasketNews(String id, String headline) {
        String firstPrompt = "Enter the competition";
        String secondPrompt = "Enter the club";
        String competition;
        String club;
        String response = "Basketball news item assigned";

        competition = enterString(firstPrompt);
        club = enterString(secondPrompt);
        Journalist journalist = findJournalist(id);

        BasketballNews basketballNews = new BasketballNews(headline, journalist, competition, club);
        journalist.getNews().add(basketballNews);

        return response;
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
