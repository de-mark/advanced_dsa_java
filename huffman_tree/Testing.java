package huffman_tree;

public class Testing {
    public static void main(String[] args) {
        // TESTING MINHEAP

        // MinHeapPQ pq = new MinHeapPQ(25);

        // Tree a = new Tree();
        // a.insert('a', 5);
        // a.insert('e', 2);
        // a.insert('d', 7);
        // System.out.println("[A]");
        // a.display();

        // Tree b = new Tree();
        // b.insert('b', 10);
        // b.insert('q', 12);
        // b.insert('z', 1);
        // System.out.println("[A]");
        // b.display();

        // Tree c = new Tree();
        // c.insert('c', 2);
        // c.insert('x', 10);
        // c.insert('z', 1);
        // System.out.println("[A]");
        // c.display();

        // pq.enqueue(a);
        // pq.enqueue(b);
        // pq.enqueue(c);

        // System.out.println("[PQ HEAD]");
        // pq.peek().display();
        // System.out.println("[PQ REMOVED TOP]");
        // pq.dequeue();
        // pq.peek().display();
        //

        // TESTING HUFFMAN

        Huffman hm = new Huffman();

        hm.encodeMessage("72823 susie says it is 78ea8sy!!!!");

        hm.displayFrequencyTable();
        System.out.println("");
        hm.displayCodeTable();
        System.out.println("");
        hm.displayEncodedMessage();
        hm.decodeMessage();
    }
}