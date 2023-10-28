package huffman_tree;

public class Homework {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(25);
        pq.enqueue(43);
        pq.enqueue(333);
        pq.enqueue(345);
        pq.enqueue(45);
        pq.enqueue(3);
        pq.enqueue(400);
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
        System.out.println(pq.dequeue());
    }
}
