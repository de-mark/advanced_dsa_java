package huffman_tree;

import java.util.*;

public class Homework {
    public static void main(String[] args) {
        String userInput;
        Scanner sc = new Scanner(System.in);
        System.out.println("--[ HUFFMAN ENCODER ]----------------");
        System.out.print("Enter a string to encode:\t");
        userInput = sc.nextLine();
        System.out.println("\n------------------------------\n\n");
        Huffman hm = new Huffman();
        hm.encodeMessage(userInput);
        hm.displayFrequencyTable();
        System.out.println("");
        hm.displayCodeTable();
        System.out.println("");
        hm.decodeMessage();
        sc.close();
    }
}
