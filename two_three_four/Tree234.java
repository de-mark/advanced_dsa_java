package two_three_four;

public class Tree234 {
    Node root;

    public Tree234() {
        root = new Node();
    }

    public int find(int key) {
        Node curr = root;
        int index = curr.findItem(key);
        while (index == -1) {
            curr = getNextChild(curr, key);
            index = curr.findItem(key);
            if (index != -1)
                return index;
            else if (curr.isLeaf())
                return -1;
        }
        return index;
    }

    public void insert(int item) {
        Node curr = root;

        while (true) {
            if (curr.isFull()) {
                split(curr);
                curr = curr.getParent();
                curr = getNextChild(curr, item);
            } else if (curr.isLeaf())
                break;
            else
                curr = getNextChild(curr, item);
        }
        curr.insertItem(item);
    }

    public Node getNextChild(Node curr, int item) {
        int i;
        for (i = 0; i < curr.numOfItems; i++) {
            if (item < curr.data[i])
                return curr.getChild(i);
        }
        return curr.getChild(i);
    }

    public void split(Node curr) {
        Node sibling = new Node();
        Node parent;
        int itemC = curr.removeItem();
        int itemB = curr.removeItem();
        Node child2 = curr.disconnectChild(2);
        Node child3 = curr.disconnectChild(3);

        if (curr == root) {
            root = new Node();
            parent = root;
            root.connectChild(curr, 0);
        } else
            parent = curr.getParent();

        int index = parent.insertItem(itemB);
        int n = parent.numOfItems;

        for (int i = n - 1; i > index; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(temp, index + 1);
        }

        parent.connectChild(sibling, index + 1);
        sibling.insertItem(itemC);
        sibling.connectChild(child2, 0);
        sibling.connectChild(child3, 1);
    }
}
