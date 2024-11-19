package imf.model;

public class FootballNews extends News {
    private String competition;
    private String club;
    private String player;

    public FootballNews(String headline, Journalist journalist, String competition, String club, String player) {
        super(headline, journalist);
        this.competition = competition;
        this.club = club;
        this.player = player;
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

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public float calculateArticlePrice() {
        float articlePrice = 300;
        articlePrice += (this.competition.equalsIgnoreCase("Champions League")) ? 100F : 0;
        articlePrice += (this.club.equalsIgnoreCase("FC Barcelona") || this.club.equalsIgnoreCase("Madrid")) ? 100F : 0;
        articlePrice += (this.player.equalsIgnoreCase("Ferran Torres")
                || this.player.equalsIgnoreCase("Benzema")) ? 50F : 0;

        return articlePrice;
    }

    public short calculateNewsRating() {
        short newsRating = 5;
        newsRating += (this.competition.equalsIgnoreCase("Champions League")) ? (short)3 : 0;
        newsRating += (this.competition.equalsIgnoreCase("Primera")) ? (short)2 : 0;
        newsRating += (this.club.equalsIgnoreCase("FC Barcelona")
                || this.club.equalsIgnoreCase("Madrid")) ? (short)1 : 0;
        newsRating += (this.player.equalsIgnoreCase("Ferran Torres")
                || this.player.equalsIgnoreCase("Benzema")) ? (short)1 : 0;

        return newsRating;
    }
}
