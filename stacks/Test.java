package stacks;

public class Test {
    public static void main(String[] args) {
        ArrayStack s = new ArrayStack(10);
        s.push(34);
        s.push(65);
        s.push(11);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }
}
