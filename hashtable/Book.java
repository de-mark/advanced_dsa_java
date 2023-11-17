package hashtable;

public class Book {
    private String title;
    private String author;
    private String topic;

    public Book(String title, String author, String topic) {
        this.title = title;
        this.author = author;
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTopic() {
        return topic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTopic(String newTopic) {
        this.topic = newTopic;
    }
}
