package two_three;

public class Homework {
    // Insert items
    // Display Tree
    // Allow Searches

    private static void displaySearch(int searchResult) {
        if (searchResult != -1) {
            System.out.printf("Found at index %d\n", searchResult);
        } else {
            System.out.println("Could not find");
        }
    }

    public static void main(String[] args) {
        TwoThree tree = new TwoThree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(7);
        tree.insert(8);
        tree.insert(12);
        tree.insert(50);
        tree.insert(72);
        System.out.println("INITIAL TREE");
        System.out.println("----------------");
        tree.inOrderTraversal();
        System.out.println("\n----------------\n");
        System.out.println("SEARCHING 20");
        int found20 = tree.find(20);
        displaySearch(found20);
        System.out.println("\n----------------\n");
        System.out.println("SEARCHING 72");
        int found72 = tree.find(72);
        displaySearch(found72);
        System.out.println("\n----------------\n");
        System.out.println("SEARCHING 82821 (Should return not found without crashing)");
        int found82821 = tree.find(82821);
        displaySearch(found82821);
        System.out.println("\n----------------\n");
        System.out.println("ADDING 102");
        tree.insert(102);
        tree.inOrderTraversal();
    }
}
