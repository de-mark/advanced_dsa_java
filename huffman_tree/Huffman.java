package huffman_tree;

public class Huffman {
    private int[] freqTable;
    private String[] codeTable;
    private Tree huffTree;

    private String originalMessage;
    private String encodedMessage;

    public Huffman() {
        freqTable = new int[27];
        codeTable = new String[27];
        clearTables();
    }

    private void clearTables() {
        for (int i = 0; i < freqTable.length; i++) {
            freqTable[i] = 0;
        }
        for (int i = 0; i < codeTable.length; i++) {
            codeTable[i] = "";
        }
    }

    private int getIndexForChar(char c) {
        int asciiVal = (int) c;
        int idx;

        if (asciiVal == 32) {
            idx = 26;
        } else {
            idx = asciiVal - (int) 'a';
        }

        return idx;
    }

    private char getCharForIndex(int idx) {
        if (idx == 26) {
            return ' ';
        } else {
            return (char) (idx + (int) 'a');
        }
    }

    private boolean isLeaf(Node currNode) {
        return currNode.getLeft() == null && currNode.getRight() == null;
    }

    private void buildPaths(Node currNode, String str) {
        if (currNode == null) {
            return;
        }

        if (isLeaf(currNode)) {
            codeTable[getIndexForChar(currNode.getLetter())] = str.length() > 0 ? str : "1";
        }

        buildPaths(currNode.getLeft(), str + "0");
        buildPaths(currNode.getRight(), str + "1");
    }

    private String cleanMessage(String rawMessage) {
        return rawMessage.replaceAll("\\p{Punct}", "")
                .replaceAll("\\d", "")
                .toLowerCase()
                .trim()
                .replaceAll(" +", " ");
    }

    public void encodeMessage(String messageToEncode) {
        clearTables();
        originalMessage = messageToEncode;
        messageToEncode = cleanMessage(messageToEncode);

        for (int m = 0; m < messageToEncode.length(); m++) {
            char c = (char) messageToEncode.charAt(m);
            int idx = getIndexForChar(c);

            freqTable[idx]++;
        }

        MinHeapPQ pq = new MinHeapPQ(messageToEncode.length());

        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] > 0) {
                Tree newTree = new Tree();
                newTree.insert(getCharForIndex(i), freqTable[i]);
                pq.enqueue(newTree);
            }
        }

        while (pq.getNumItems() > 1) {
            Tree firstTree = pq.dequeue();
            Tree secondTree = pq.dequeue();
            Tree sumTree = new Tree();
            sumTree.insert('+', firstTree.getRootFrequency() + secondTree.getRootFrequency());
            sumTree.getRoot().setLeft(firstTree.getRoot());
            sumTree.getRoot().setRight(secondTree.getRoot());
            pq.enqueue(sumTree);
        }

        huffTree = pq.dequeue();

        buildPaths(huffTree.getRoot(), "");

        encodedMessage = "";

        for (int s = 0; s < messageToEncode.length(); s++) {
            char c = (char) messageToEncode.charAt(s);
            int idx = getIndexForChar(c);
            String enc = codeTable[idx];
            String endingWhiteSpace = s == messageToEncode.length() - 1 ? "" : " ";
            encodedMessage = encodedMessage + enc + endingWhiteSpace;
        }
    }

    public void displayFrequencyTable() {
        System.out.println("FREQUENCY TABLE----------------------------");
        for (int i = 0; i < 27; i++) {
            if (freqTable[i] != 0) {
                System.out.printf("[ CHAR: %c | FREQ: %d]\n", getCharForIndex(i), freqTable[i]);
            }
        }
    }

    public void displayCodeTable() {
        System.out.println("CODE TABLE----------------------------");
        for (int i = 0; i < 27; i++) {
            if (codeTable[i] != "") {
                System.out.printf("[ CHAR: %c | FREQ: %s]\n", getCharForIndex(i), codeTable[i]);
            }
        }
    }

    public void displayEncodedMessage() {
        System.out.println("ENCODED MESSAGE----------------------------");
        System.out.printf("[ORIGINAL] %s\n", originalMessage);
        System.out.printf("[ENCODED] %s\n\n", encodedMessage);
    }

    // public Tree decodeMessage() {

    // }
}
