package huffman_tree;

public class Tree {
    private Node root;

    public Tree() {
    }

    public Node getRoot() {
        return root;
    }

    public int getRootFrequency() {
        if (root == null) {
            return -1;
        } else {
            return root.getFrequency();
        }
    }

    public void insert(char letter, int frequency) {
        Node newNode = new Node(letter, frequency);

        Node parent = null, curr = this.root;

        while (curr != null) {
            parent = curr;

            if (newNode.getFrequency() < curr.getFrequency()) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }

        newNode.setParent(parent);

        if (parent == null) {
            root = newNode;
        } else if (newNode.getFrequency() < parent.getFrequency()) {
            parent.setLeft(newNode);
        } else {
            parent.setRight(newNode);
        }
    }

    public boolean compareTo(Tree otherTreeInstance) {
        if (this.getRootFrequency() > otherTreeInstance.getRootFrequency()) {
            return true;
        } else {
            return false;
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.printf("[%d - %c] ", node.getFrequency(), node.getLetter());
            inOrder(node.getRight());
        }
    }

    public void display() {
        inOrder(this.root);
        System.out.println("");
    }
}
