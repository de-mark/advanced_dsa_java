package huffman_tree;

public class Testing {
    public static void main(String[] args) {
        // PriorityQueue pq = new PriorityQueue(25);
        // pq.enqueue(43);
        // pq.enqueue(333);
        // pq.enqueue(345);
        // pq.enqueue(45);
        // pq.enqueue(3);
        // pq.enqueue(400);
        // System.out.println(pq.dequeue());
        // System.out.println(pq.dequeue());
        // System.out.println(pq.dequeue());
        // System.out.println(pq.dequeue());
        // System.out.println(pq.dequeue());
        // System.out.println(pq.dequeue());

        MinHeapPQ pq = new MinHeapPQ(25);

        Tree a = new Tree();
        a.insert('a', 5);
        a.insert('e', 2);
        a.insert('d', 7);
        System.out.println("[A]");
        a.display();

        Tree b = new Tree();
        b.insert('b', 10);
        b.insert('q', 12);
        b.insert('z', 1);
        System.out.println("[A]");
        b.display();

        Tree c = new Tree();
        c.insert('c', 2);
        c.insert('x', 10);
        c.insert('z', 1);
        System.out.println("[A]");
        c.display();

        pq.enqueue(a);
        pq.enqueue(b);
        pq.enqueue(c);

        System.out.println("[PQ HEAD]");
        pq.peek().display();
        System.out.println("[PQ REMOVED TOP]");
        pq.dequeue();
        pq.peek().display();
    }
}
