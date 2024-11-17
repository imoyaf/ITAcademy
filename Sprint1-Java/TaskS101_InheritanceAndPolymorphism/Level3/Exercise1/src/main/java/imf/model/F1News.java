package imf.entities;

public class F1News extends News {
    private String team;

    public F1News(String headline, Journalist journalist, String team) {
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
        articlePrice += (this.team.equalsIgnoreCase("Ferrari")
                || this.team.equalsIgnoreCase("Mercedes")) ? 50F : 0;

        return articlePrice;
    }

    public short calculateNewsRating() {
        short newsRating = 4;
        newsRating += (this.team.equalsIgnoreCase("Ferrari")
            || this.team.equalsIgnoreCase("Mercedes")) ? (short)2 : 0;

        return newsRating;
    }
}
