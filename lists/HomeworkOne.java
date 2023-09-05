package lists;

import java.util.Random;

public class HomeworkOne {
    public static void main(String[] args) {
        Random rand = new Random();
        int upperBound = 500;

        OrderedList a = new OrderedList(5);
        OrderedList b = new OrderedList(10);
        OrderedList c;

        for (int rn = 0; rn < 5; rn++) {
            a.insert(rand.nextInt(upperBound));
        }

        System.out.println("ORDERED ARRAY 1 -");
        a.display();
        System.out.println();

        for (int rn = 0; rn < 10; rn++) {
            b.insert(rand.nextInt(upperBound));
        }

        System.out.println("ORDERED ARRAY 2 -");
        b.display();
        System.out.println();

        c = a.merge(b);

        System.out.println("MERGED ARRAY -");
        c.display();
        System.out.println();
    }
}