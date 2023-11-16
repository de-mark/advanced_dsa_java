package two_three_four;

public class Homework {
    public static void main(String[] args) {
        TwoThreeFour tree = new TwoThreeFour();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(7);
        tree.insert(8);
        tree.inOrderTraversal();
    }
}
