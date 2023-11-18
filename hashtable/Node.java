package hashtable;

public class Node {
    private Book book;
    private Node left;
    private Node right;

    public Node(int id, String title, String author, String topic) {
        Book newBook = new Book(id, title, author, topic);
        this.book = newBook;
    }

    public Node(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public int getId() {
        return book.getId();
    }

    public String getTitle() {
        return book.getTitle();
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public String getTopic() {
        return book.getTopic();
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setId(int id) {
        book.setId(id);
    }

    public void setTitle(String title) {
        book.setTitle(title);
    }

    public void setAuthor(String author) {
        book.setAuthor(author);
    }

    public void setTopic(String topic) {
        book.setTopic(topic);
    }

    public void display() {
        book.display();
    }
}
