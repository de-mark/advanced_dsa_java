package hashtable;

public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public BST(Node root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int id, String title, String author, String topic) {
        Node newNode = new Node(id, title, author, topic);
        insert(newNode);
    }

    public void insert(Book newBook) {
        Node newNode = new Node(newBook);
        insert(newNode);
    }

    public void insert(Node newNode) {
        int id = newNode.getId();

        if (isEmpty()) {
            root = newNode;
        } else {
            Node curr = root;
            Node prev = null;

            while (true) {
                prev = curr;

                if (id < curr.getId()) {
                    curr = curr.getLeft();
                    if (curr == null) {
                        prev.setLeft(newNode);
                        break;
                    }
                } else {
                    curr = curr.getRight();
                    if (curr == null) {
                        prev.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    private void inorder(Node curr) {
        if (curr != null) {
            inorder(curr.getLeft());
            curr.display();
            inorder(curr.getRight());
        }
    }

    public void inorder() {
        inorder(root);
    }

    public Node find(int toFind) {
        Node curr = root;

        while (curr.getId() != toFind) {
            if (toFind < curr.getId()) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
            if (curr == null) {
                return null;
            }
        }

        return curr;
    }

    private Node getSuccessor(Node del) {
        Node successorP = del;
        Node successor = del.getRight();
        Node curr = del.getRight();

        while (curr != null) {
            successorP = successor;
            successor = curr;
            curr = curr.getLeft();
        }

        if (successor != del.getRight()) {
            successorP.setLeft(successor.getRight());
            successor.setRight(del.getRight());
        }

        return successor;
    }

    public boolean delete(int id) {
        Node curr = root;
        Node parent = null;

        boolean isLeftChild = true;

        while (curr.getId() != id) {
            parent = curr;

            if (id < curr.getId()) {
                curr = curr.getLeft();
                isLeftChild = true;
            } else {
                curr = curr.getRight();
                isLeftChild = false;
            }

            if (curr == null) {
                return false;
            }
        }

        // If leaf
        if (curr.getLeft() == null && curr.getRight() == null) {
            if (curr == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if (curr.getRight() == null) {
            if (curr == root) {
                root = curr.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(curr.getLeft());
            } else {
                parent.setRight(curr.getLeft());
            }
        } else if (curr.getLeft() == null) {
            if (curr == root) {
                root = curr.getRight();
            } else if (isLeftChild) {
                parent.setLeft(curr.getRight());
            } else {
                parent.setRight(curr.getRight());
            }
        } else {
            Node successor = getSuccessor(curr);

            if (curr == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }

            successor.setLeft(curr.getLeft());
        }

        return true;
    }
}
