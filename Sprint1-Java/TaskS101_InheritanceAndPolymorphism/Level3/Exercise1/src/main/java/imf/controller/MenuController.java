package imf.controller;

import imf.model.*;
import imf.view.MenuView;
import imf.view.MenuViewUtils;

import java.util.ArrayList;

import static imf.controller.MenuControllerUtils.*;

public class MenuController {
    public static ArrayList<Journalist> journalists = new ArrayList<>();
    MenuControllerUtils menuControllerUtils = new MenuControllerUtils();
    MenuView menuView = new MenuView();
    MenuViewUtils menuViewUtils = new MenuViewUtils();
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
            "5. Motocross\n";
    String journoNamePrompt = "Enter the name of the journalist: ";
    String journoIdNumberPrompt = "Enter Journalist ID number: ";
    String headlinePrompt = "Enter the news item headline: ";
    String competitionPrompt = "Enter the competition: ";
    String clubPrompt = "Enter the club: ";
    String playerPrompt = "Enter the player name: ";
    String teamPrompt = "Enter the team name: ";

    public MenuController() {
    }

    public void optionManager() {
        boolean exit = false;
        while (!exit) {
            switch (menuView.userOption(menu)) {
                case (byte) 1 -> enterJournalist();
                case (byte) 2 -> deleteJournalist();
                case (byte) 3 -> assignNews();
                case (byte) 4 -> deleteNews();
                case (byte) 5 -> findJournalistNews();
                case (byte) 6 -> newsRating();
                case (byte) 7 -> newsPrice();
                case (byte) 8 -> {
                    exit = true;
                    menuViewUtils.feedbackMessage("Thank you for using the news manager\n");
                }
                default -> menuViewUtils.feedbackMessage("You can only choose options 1-8");
            }
        }
    }

    public void sportOptionManager(String id) {
        byte sport;
        sport = menuView.userOption(sportMenu);
        switch (sport) {
            case (byte) 1 -> assignFootballNews(id, menuControllerUtils.getHeadlineFromUser());
            case (byte) 2 -> assignBasketNews(id, menuControllerUtils.getHeadlineFromUser());
            case (byte) 3 -> assignTennisNews(id, menuControllerUtils.getHeadlineFromUser());
            case (byte) 4 -> assignFormula1News(id, menuControllerUtils.getHeadlineFromUser());
            case (byte) 5 -> assignMotocrossNews(id, menuControllerUtils.getHeadlineFromUser());
            default -> menuViewUtils.feedbackMessage("You can only choose options 1-5");
        }
    }

    public void enterJournalist() {
        String name;
        String id;
        String response;

        name = menuViewUtils.enterString(journoNamePrompt);
        id = menuControllerUtils.getIdFromUser();
        if (menuControllerUtils.idFound(id)) {
            response = "This id is already in use\n";
        } else {
            Journalist journalist = new Journalist(name, id);
            journalists.add(journalist);
            response = "\nJournalist added successfully\n";
        }
        showJournalists();
        menuViewUtils.feedbackMessage(response);
    }

    public void deleteJournalist() {
        String id;
        String response;
        id = menuControllerUtils.getIdFromUser();
        if (!menuControllerUtils.idFound(id)) {
            response = "\nId not found\n";
        } else {
            journalists.remove(menuControllerUtils.findJournalist(id));
            response = "\nJournalist deleted successfully\n";
        }
        menuViewUtils.feedbackMessage(response);
    }

    public void assignNews() {
        String id;
        String response = "";

        id = menuControllerUtils.getIdFromUser();
        if (!menuControllerUtils.idFound(id)) {
            response = "ID not found in the system";
        } else {
            sportOptionManager(id);
        }
        menuViewUtils.feedbackMessage(response);
    }

    public void assignFootballNews(String id, String headline) {
        String competition;
        String club;
        String player;

        competition = menuViewUtils.enterString(competitionPrompt);
        club = menuViewUtils.enterString(clubPrompt);
        player = menuViewUtils.enterString(playerPrompt);
        Journalist journalist = menuControllerUtils.findJournalist(id);

        FootballNews footballNews = new FootballNews(headline, journalist, competition, club, player);
        journalist.getNews().add(footballNews);

        menuViewUtils.feedbackMessage("Football news item assigned successfully");
    }

    public void assignBasketNews(String id, String headline) {
        String competition;
        String club;

        competition = menuViewUtils.enterString(competitionPrompt);
        club = menuViewUtils.enterString(clubPrompt);
        Journalist journalist = menuControllerUtils.findJournalist(id);

        BasketballNews basketballNews = new BasketballNews(headline, journalist, competition, club);
        journalist.getNews().add(basketballNews);

        menuViewUtils.feedbackMessage("Basketball news item assigned successfully");
    }

    public void assignTennisNews(String id, String headline) {
        String competition;
        String player;

        competition = menuViewUtils.enterString(competitionPrompt);
        player = menuViewUtils.enterString(playerPrompt);
        Journalist journalist = menuControllerUtils.findJournalist(id);

        TennisNews tennisNews = new TennisNews(headline, journalist, competition, player);
        journalist.getNews().add(tennisNews);

        menuViewUtils.feedbackMessage("Tennis news item assigned successfully");
    }

    public void assignFormula1News(String id, String headline) {
        String team;

        team = menuViewUtils.enterString(teamPrompt);
        Journalist journalist = menuControllerUtils.findJournalist(id);

        F1News f1News = new F1News(headline, journalist, team);
        journalist.getNews().add(f1News);

        menuViewUtils.feedbackMessage("Formula 1 news item assigned successfully");
    }

    public void assignMotocrossNews(String id, String headline) {
        String team;

        team = menuViewUtils.enterString(teamPrompt);
        Journalist journalist = menuControllerUtils.findJournalist(id);

        MotocrossNews motocrossNews = new MotocrossNews(headline, journalist, team);
        journalist.getNews().add(motocrossNews);

        menuViewUtils.feedbackMessage("Motocross news item assigned successfully");
    }

    public void deleteNews() {
        String id;
        String headline;
        String response = "Headline not found";

        id = menuViewUtils.enterString(journoIdNumberPrompt);
        if (!menuControllerUtils.idFound(id)) {
            response = "ID not found in the system";
        } else {
            headline = menuViewUtils.enterString(headlinePrompt);
            for (int i = 0; i < menuControllerUtils.findJournalist(id).getNews().size(); i++) {
                if (menuControllerUtils.findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    menuControllerUtils.findJournalist(id).getNews().remove(i);
                    response = "News item deleted successfully";
                }
            }
        }
        menuViewUtils.feedbackMessage(response);
    }

    public void findJournalistNews() {
        String response;
        String id;

        id = menuViewUtils.enterString("Enter the journalist id to show their news: ");
        if (!menuControllerUtils.idFound(id)) {
            response = "Id not found";
        } else {
            response = menuControllerUtils.findJournalist(id).getNews().toString();
        }
        menuViewUtils.feedbackMessage(response);
    }

    public void newsRating() {
        String id;
        String headline;
        String response = "Headline not found";

        id = menuViewUtils.enterString("Enter the journalist id for the news item: ");
        if (!menuControllerUtils.idFound(id)) {
            response = "Id not found";
        } else {
            headline = menuViewUtils.enterString("News headline: ");
            for (int i = 0; i < menuControllerUtils.findJournalist(id).getNews().size(); i++) {
                if (menuControllerUtils.findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    response = "News rating: " + menuControllerUtils.findJournalist(id).getNews().get(i).calculateNewsRating();
                }
            }
        }
        menuViewUtils.feedbackMessage(response);
    }

    public void newsPrice() {
        String id;
        String headline;
        String response = "Headline not found";

        id = menuViewUtils.enterString("Enter the journalist id for the news item: ");
        if (!menuControllerUtils.idFound(id)) {
            response = "Id not found";
        } else {
            headline = menuViewUtils.enterString("News headline: ");
            for (int i = 0; i < menuControllerUtils.findJournalist(id).getNews().size(); i++) {
                if (menuControllerUtils.findJournalist(id).getNews().get(i).getHeadline().equalsIgnoreCase(headline)) {
                    response = "News item price: " + menuControllerUtils.findJournalist(id).getNews().get(i).calculateArticlePrice();
                }
            }
        }
        menuViewUtils.feedbackMessage(response);
    }
}
