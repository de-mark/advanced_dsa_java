package hashtable;

// Hashtable utilizes Separate Chaining for collisions
public class HashTable {
    BST[] table;

    public HashTable(int size) {
        table = new BST[size];

        for (int i = 0; i < size; i++) {
            table[i] = new BST();
        }
    }

    public int hash(int id) {
        return id % table.length;
    }

    public void insert(Book newBook) {
        Node newNode = new Node(newBook);
        insert(newNode);
    }

    public void insert(Node newNode) {
        int idx = hash(newNode.getId());
        table[idx].insert(newNode);
    }

    public void delete(int id) {
        int idx = hash(id);
        table[idx].delete(id);
    }

    public Node find(int id) {
        int idx = hash(id);
        Node newNode = table[idx].find(id);
        return newNode;
    }

    public void display() {
        for (int i = 0; i < table.length; i++) {
            System.out.printf("%d. ====================================\n", i);
            table[i].inorder();
            System.out.print("\n");
        }
    }

}
