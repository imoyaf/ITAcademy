package imf.entities;

public class MotocrossNews extends News {
    private String team;

    public MotocrossNews(String headline, Journalist journalist, String team) {
        super(headline, journalist);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public float calculateArticlePrice() {
        float articlePrice = 100;
        articlePrice += (this.team.equalsIgnoreCase("Honda")
                || this.team.equalsIgnoreCase("Yamaha")) ? 50F
                : 0;

        return articlePrice;
    }

    public short calculateNewsRating() {
        short newsRating = 3;
        newsRating += (this.team.equalsIgnoreCase("Honda")
                || this.team.equalsIgnoreCase("Yamaha")) ? (short)3
                : 0;

        return newsRating;
    }
}
