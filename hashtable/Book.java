package hashtable;

public class Book {
    private int id;
    private String title;
    private String author;
    private String topic;

    public Book(int id, String title, String author, String topic) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.topic = topic;
    }

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
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

    public boolean isEqualTo(Book otherBook) {
        return this.title.equals(otherBook.getTitle()) &&
                this.author.equals(otherBook.getAuthor()) &&
                this.topic.equals(otherBook.getTopic());
    }

    public void display() {
        System.out.printf("| BOOK %d: \n|TITLE: %s\n|AUTHOR: %s\n|TOPIC: %s\n--------------------\n\n", id, title,
                author, topic);
    }
}
