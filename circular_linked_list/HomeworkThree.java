package circular_linked_list;

public class HomeworkThree {

    public static void main(String[] args) {
        CircularLinkedList circ = new CircularLinkedList();
        System.out.println("Adding 5");
        circ.insert(5);
        System.out.println("Adding 6");
        circ.insert(6);
        System.out.println("Adding 7");
        circ.insert(7);
        System.out.println("------------");
        circ.display();
        System.out.println("------------");
        System.out.println("Adding 10");
        circ.insert(10);
        System.out.println("Adding 12");
        circ.insert(12);
        System.out.println("------------");
        circ.display();
        System.out.println("------------");
        System.out.println("Deleting 5");
        circ.delete(5);
        System.out.println("------------");
        circ.display();
        System.out.println("------------");
        System.out.println("Deleting 10");
        circ.delete(10);
        System.out.println("------------");
        circ.display();
        System.out.println("------------");
        System.out.println("Deleted 12");
        circ.delete(12);
        System.out.println("------------");
        circ.display();
        System.out.println("------------");
        System.out.println("Adding 300");
        circ.insert(300);
        System.out.println("------------");
        circ.display();
    }
}
