package imf.model;

public class TennisNews extends News {
    private String competition;
    private String player;

    public TennisNews(String headline, Journalist journalist, String competition, String player) {
        super(headline, journalist);
        this.competition = competition;
        this.player = player;
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public float calculateArticlePrice() {
        float articlePrice = 150;
        articlePrice += (this.player.equalsIgnoreCase("Federer") || this.player.equalsIgnoreCase("Nadal")
                || this.player.equalsIgnoreCase("Djokovic")) ? 100F : 0;

        return articlePrice;
    }

    public short calculateNewsRating() {
        short newsRating = 4;
        newsRating += (this.player.equalsIgnoreCase("Federer")
                || this.player.equalsIgnoreCase("Nadal")
                || this.player.equalsIgnoreCase("Djokovic")) ? (short)3 : 0;

        return newsRating;
    }
}
