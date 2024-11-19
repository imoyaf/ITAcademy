package imf.model;

public abstract class News {
    private String headline;
    private String text;
    private float price;
    private short rating;
    private Journalist journalist;

    public News(String headline, Journalist journalist) {
        this.headline = headline;
        this.journalist = journalist;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    @Override
    public String toString() {
        return "News headline: " + this.headline + ", text: " + this.text;
    }

    public abstract float calculateArticlePrice();

    public abstract short calculateNewsRating();
}
