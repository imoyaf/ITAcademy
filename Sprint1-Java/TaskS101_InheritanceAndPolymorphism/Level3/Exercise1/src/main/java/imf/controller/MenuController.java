package imf.controller;

import imf.model.*;

import java.util.ArrayList;

import static imf.controller.MenuUtils.*;
import static imf.view.MenuView.*;

public class MenuController {
    public static ArrayList<Journalist> journalists = new ArrayList<>();

    public static String enterJournalist() {
        String firstPrompt = "Enter the name of the journalist";
        String secondPrompt = "Enter id number";
        String name;
        String id;
        String response;

        name = enterString(firstPrompt);
        id = enterString(secondPrompt);
        if (idFound(id)) {
            response = "This id is already in use\n";
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
        String firstPrompt = "Enter the competition: ";
        String secondPrompt = "Enter the club: ";
        String thirdPrompt = "Enter the player: ";
        String competition;
        String club;
        String player;

        competition = enterString(firstPrompt);
        club = enterString(secondPrompt);
        player = enterString(thirdPrompt);
        Journalist journalist = findJournalist(id);

        FootballNews footballNews = new FootballNews(headline, journalist, competition, club, player);
        journalist.getNews().add(footballNews);

        return "Football news item assigned";
    }

    public static String assignBasketNews(String id, String headline) {
        String firstPrompt = "Enter the competition: ";
        String secondPrompt = "Enter the club: ";
        String competition;
        String club;

        competition = enterString(firstPrompt);
        club = enterString(secondPrompt);
        Journalist journalist = findJournalist(id);

        BasketballNews basketballNews = new BasketballNews(headline, journalist, competition, club);
        journalist.getNews().add(basketballNews);

        return "Basketball news item assigned";
    }

    public static String assignTennisNews(String id, String headline) {
        String firstPrompt = "Enter the competition: ";
        String secondPrompt = "Enter the player: ";
        String competition;
        String player;

        competition = enterString(firstPrompt);
        player = enterString(secondPrompt);
        Journalist journalist = findJournalist(id);

        TennisNews tennisNews = new TennisNews(headline, journalist, competition, player);
        journalist.getNews().add(tennisNews);

        return "Tennis news item assigned";
    }

    public static String assignFormula1News(String id, String headline) {
        String firstPrompt = "Enter the team: ";
        String team;

        team = enterString(firstPrompt);
        Journalist journalist = findJournalist(id);

        F1News f1News = new F1News(headline, journalist, team);
        journalist.getNews().add(f1News);

        return "Formula 1 news item assigned";
    }

    public static String assignMotocrossNews(String id, String headline) {
        String firstPrompt = "Enter the team: ";
        String team;

        team = enterString(firstPrompt);
        Journalist journalist = findJournalist(id);

        MotocrossNews motocrossNews = new MotocrossNews(headline, journalist, team);
        journalist.getNews().add(motocrossNews);

        return "Motocross news item assigned";
    }

    public static String deleteNews() {
        String firstPrompt = "Enter the journalist id to delete the news item: ";
        String secondPrompt = "News headline: ";
        String id;
        String headline;
        String response = "Headline not found";

        id = enterString(firstPrompt);
        if (!idFound(id)) {
            response = "ID not found in the system";
        } else {
            headline = enterString(secondPrompt);
            for (int i = 0; i < findJournalist(id).getNews().size(); i++) {
                if (findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    findJournalist(id).getNews().remove(i);
                    response = "News item deleted successfully";
                } else {
                    response = "Headline not found";
                }
            }
        }
        return response;
    }

    public static String findJournalistNews() {
        String response;
        String id;

        id = enterString("Enter the journalist id to show their news: ");
        if (!idFound(id)) {
            response = "Id not found";
        } else {
            response = findJournalist(id).getNews().toString();
        }
        return response;
    }

    public static String newsRating() {
        String id;
        String headline;
        String response = "Headline not found";

        id = enterString("Enter the journalist id for the news item: ");
        if (!idFound(id)) {
            response = "Id not found";
        } else {
            headline = enterString("News headline: ");
            for (int i = 0; i < findJournalist(id).getNews().size(); i++) {
                if (findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    response = "News rating: " + findJournalist(id).getNews().get(i).calculateNewsRating();
                } else {
                    response = "Headline not found";
                }
            }
        }
        return response;
    }

    public static String newsPrice() {
        String id;
        String headline;
        String response = "Headline not found";

        id = enterString("Enter the journalist id for the news item: ");
        if (!idFound(id)) {
            response = "Id not found";
        } else {
            headline = enterString("News headline: ");
            for (int i = 0; i < findJournalist(id).getNews().size(); i++) {
                if (findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    response = "News item price: " + findJournalist(id).getNews().get(i).calculateArticlePrice();
                }
            }
        }
        return response;
    }

}
