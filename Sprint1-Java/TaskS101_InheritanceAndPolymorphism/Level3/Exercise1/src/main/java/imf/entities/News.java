package imf.entities;

public abstract class News {
    private String headline;
    private String text;
    private float price;
    private int rating;
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

    public void setRating(int rating) {
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
        return "\nNews. Headline:" + this.headline +
                ", text:" + this.text +
                ", price:" + this.price +
                ", rating:" + this.rating;
    }

    public abstract int calculateArticlePrice();

    public abstract int calculateRatingNews();
}
