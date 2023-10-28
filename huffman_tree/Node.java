package huffman_tree;

public class Node {
    private char letter;
    private int frequency;

    private Node parent;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(char newLetter, int newFrequency) {
        letter = newLetter;
        frequency = newFrequency;
    }

    public char getLetter() {
        return letter;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getParent() {
        return parent;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLetter(char newLetter) {
        letter = newLetter;
    }

    public void setFrequency(char newFrequency) {
        frequency = newFrequency;
    }

    public void setParent(Node newParent) {
        parent = newParent;
    }

    public void setLeft(Node newLeft) {
        left = newLeft;
    }

    public void setRight(Node newRight) {
        right = newRight;
    }

}
