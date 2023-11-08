package two_three_four;

public class Homework {
    public static void main(String[] args){
        Tree234 t = new Tree234();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(7);
        t.insert(8);
        System.out.println(t.find(8));
    }
}
