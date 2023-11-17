package hashtable;

public class Node {
    private Book book;
    private Node left;
    private Node right;

    public Node(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
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

}
