package two_three_four;

public class Homework {
    public static void main(String[] args) {
        TwoThreeFour tree = new TwoThreeFour();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(7);
        tree.insert(8);
        System.out.println("INITIAL TREE");
        System.out.println("----------------");
        tree.inOrderTraversal();
        System.out.println("\n----------------\n");
        System.out.println("DELETING 20");
        tree.delete(20);
        tree.inOrderTraversal();
        System.out.println("\n----------------\n");
        System.out.println("DELETING 8");
        tree.delete(20);
        tree.inOrderTraversal();
        System.out.println("\n----------------\n");
        System.out.println("ADDING 102");
        tree.insert(102);
        tree.inOrderTraversal();
    }
}
