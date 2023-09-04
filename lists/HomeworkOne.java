package lists;

public class HomeworkOne {
    public static void main(String[] args) {
        UnorderedList a = new UnorderedList(5);

        System.out.println(a.isEmpty());
        a.delete(5);
        a.insert(4);
        a.insert(9);
        a.insert(6);
        a.insert(2);
        a.display();

        System.out.println("-------");

        a.delete(9);
        a.insert(1);
        a.delete(4);
        a.display();
    }
}