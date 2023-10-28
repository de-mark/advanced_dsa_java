package huffman_tree;

public class Huffman {
    private int[] freqTable;
    private String[] codeTable;
    private Tree huffTree;

    private String originalMessage;
    private String encodedMessage;
    private String cleanedMessage;
    private String decodedMessage;

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
        // Since we're encoding something new, we want to clear the existing values
        clearTables();
        decodedMessage = "";
        originalMessage = messageToEncode;
        messageToEncode = cleanMessage(messageToEncode);
        cleanedMessage = messageToEncode;

        // Going through the message and building the Frequency Table
        for (int m = 0; m < messageToEncode.length(); m++) {
            char c = (char) messageToEncode.charAt(m);
            int idx = getIndexForChar(c);

            freqTable[idx]++;
        }

        // Building a Priority Queue (implemented with an array-based minheap) to hold
        // the trees needed for Huffman encoding
        MinHeapPQ pq = new MinHeapPQ(messageToEncode.length());

        // Creating Trees for each character / frequency pair and adding them to the
        // Priority Queue
        // The Priority Queue prioritizes minimum frequency trees
        // Organized based on the root's frequency value
        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] > 0) {
                Tree newTree = new Tree();
                newTree.insert(getCharForIndex(i), freqTable[i]);
                pq.enqueue(newTree);
            }
        }

        // Building the Huffman tree by deque-ing two Trees and adding them to a new
        // tree whose frequency is the sum of its children's root
        // In this code, I use '+' for the sum nodes instead of leaving them blank
        while (pq.getNumItems() > 1) {
            Tree firstTree = pq.dequeue();
            Tree secondTree = pq.dequeue();
            Tree sumTree = new Tree();
            sumTree.insert('+', firstTree.getRootFrequency() + secondTree.getRootFrequency());
            sumTree.getRoot().setLeft(firstTree.getRoot());
            sumTree.getRoot().setRight(secondTree.getRoot());
            pq.enqueue(sumTree);
        }

        // Pulling the resulting tree from the priority queue and storing it within the
        // Huffman object
        // so that it can be easily accessed for decoding as well.
        huffTree = pq.dequeue();

        // Recursively populates the codeTable with Huffman paths
        // If we have to go right to reach the node, it adds a '1', if we have to go
        // left, it adds a '0'
        buildPaths(huffTree.getRoot(), "");

        // Building the encoded message and saving it to the Huffman object for ease of
        // access later
        encodedMessage = "";

        // Using the cleaned version of the original message to build the encoded
        // message
        // We uses spaces as a delimiter
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
        System.out.printf("[ORIGINAL MESSAGE] %s\n", originalMessage);
        System.out.printf("[CLEANED MESSAGE] %s\n\n", cleanedMessage);
        for (int i = 0; i < 27; i++) {
            if (freqTable[i] != 0) {
                System.out.printf("[ CHAR: %c | FREQ: %d]\n", getCharForIndex(i), freqTable[i]);
            }
        }
    }

    public void displayCodeTable() {
        System.out.println("CODE TABLE----------------------------");
        System.out.printf("[ORIGINAL MESSAGE] %s\n", originalMessage);
        System.out.printf("[CLEANED MESSAGE] %s\n\n", cleanedMessage);
        for (int i = 0; i < 27; i++) {
            if (codeTable[i] != "") {
                System.out.printf("[ CHAR: %c | FREQ: %s]\n", getCharForIndex(i), codeTable[i]);
            }
        }
    }

    public void displayEncodedMessage() {
        System.out.println("ENCODED MESSAGE----------------------------");
        System.out.printf("[ORIGINAL MESSAGE] %s\n", originalMessage);
        System.out.printf("[CLEANED MESSAGE] %s\n", cleanedMessage);
        System.out.printf("[ENCODED MESSAGE] %s\n\n", encodedMessage);
    }

    public void decodeMessage() {
        String[] toDecode = encodedMessage.split(" ");
        decodedMessage = "";

        for (int decodeIdx = 0; decodeIdx < toDecode.length; decodeIdx++) {
            String currDecode = toDecode[decodeIdx];
            Node currNode = huffTree.getRoot();

            for (int binIdx = 0; binIdx < currDecode.length(); binIdx++) {
                char binNum = currDecode.charAt(binIdx);

                if (binNum == '1') {
                    currNode = currNode.getRight();
                } else if (binNum == '0') {
                    currNode = currNode.getLeft();
                }
            }

            decodedMessage += currNode.getLetter();
        }

        System.out.println("DECODED MESSAGE----------------------------");
        System.out.printf("[ORIGINAL MESSAGE] %s\n", originalMessage);
        System.out.printf("[CLEANED MESSAGE] %s\n", cleanedMessage);
        System.out.printf("[ENCODED MESSAGE] %s\n\n", encodedMessage);
        System.out.printf("[DECODED MESSAGE] %s\n\n", decodedMessage);
    }
}
