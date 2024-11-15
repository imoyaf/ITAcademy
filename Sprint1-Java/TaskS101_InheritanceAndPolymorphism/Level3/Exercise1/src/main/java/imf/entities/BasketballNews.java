package imf.entities;

public class BasketballNews extends News {
    private String competition;
    private String club;

    public BasketballNews(String headline, Journalist journalist, String competition, String club) {
        super(headline, journalist);
        this.competition = competition;
        this.club = club;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public float calculateArticlePrice() {
        float articlePrice = 250;
        articlePrice += (this.competition.equalsIgnoreCase("EuroLeague")) ? 75F : 0;
        articlePrice += (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) ? 75F : 0;

        return articlePrice;
    }

    public short calculateNewsRating() {
        short newsRating = 4;
        newsRating += (this.competition.equalsIgnoreCase("EuroLeague")) ? (short)3 : 0;
        newsRating += (this.competition.equalsIgnoreCase("ACB")) ? (short)2 : 0;
        newsRating += (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) ? (short)1 : 0;

        return newsRating;
    }
}
