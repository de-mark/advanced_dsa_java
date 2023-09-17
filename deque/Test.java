package deque;

public class Test {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("CREATED DEQUE OF SIZE 4");
        System.out.println("--------------------------------------");
        Deque d = new Deque(4);

        System.out.println("Adding 1 to left and 2 to right");
        d.insertLeft(1);
        d.insertRight(2);
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("Adding 3 to left and 4 to right");
        d.insertLeft(3);
        d.insertRight(4);
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("Adding 10 to full deque left - SHOULD GIVE ERROR");
        d.insertLeft(10);
        System.out.println("Adding 10 to full deque right - SHOULD GIVE ERROR");
        d.insertRight(10);

        System.out.println("Checking to make sure left is still 3 and right is still 4");
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("Deleting left");
        d.deleteLeft();
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());
        System.out.println("Deleting Right");
        d.deleteRight();
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());
        System.out.println("Deleting left");
        d.deleteLeft();
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());
        System.out.println("Deleting Right");
        d.deleteRight();
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("Deleting left from empty; should give error");
        d.deleteLeft();

        System.out.println("Adding 200 to left");
        d.insertLeft(200);
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("Adding 300 to right");
        d.insertRight(300);
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("Adding 500 to left");
        d.insertLeft(500);
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("Adding 600 to right");
        d.insertRight(600);
        System.out.printf("LEFT: %d - RIGHT: %d\n", d.peekLeft(), d.peekRight());

        System.out.println("--------------------------------------");
        System.out.println("CREATED DEQUE-BASED STACK OF SIZE 4");
        System.out.println("--------------------------------------");
        DequeStack s = new DequeStack(4);

        s.push(1);
        System.out.println("Added 1");
        System.out.println(s.peek());
        s.push(2);
        System.out.println("Added 2");
        System.out.println(s.peek());
        s.push(3);
        System.out.println("Added 3");
        System.out.println(s.peek());
        s.push(4);
        System.out.println("Added 4");
        System.out.println(s.peek());
        s.push(5);
        System.out.println("Added 5 when full");
        System.out.println(s.peek());
        System.out.println("STARTING POPS");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println("Popping when empty");
        System.out.println(s.peek());
    }

}
