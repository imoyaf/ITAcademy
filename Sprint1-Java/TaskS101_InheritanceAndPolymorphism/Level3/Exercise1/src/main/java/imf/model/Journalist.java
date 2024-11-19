package imf.model;

import java.util.ArrayList;
import java.util.List;

public class Journalist {
    private String name;
    private final String id;
    private static final short SALARY = (short)150;
    private List<News> news;

    public Journalist(String name, String id) {
        this.name = name;
        this.id = id;
        this.news = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Journalist name: " + this.name + ", Id: " + this.id + ", Salary: " + SALARY
                + ", News: " + this.news.toString();
    }
}
