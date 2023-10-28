package huffman_tree;

public class Huffman {
    private int[] freqTable;
    private Tree huffTree;

    public Huffman() {
        freqTable = new int[27];
        clearFreqTable();
    }

    private void clearFreqTable() {
        for (int i = 0; i < freqTable.length; i++) {
            freqTable[i] = 0;
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

    public void encodeMessage(String messageToEncode) {
        clearFreqTable();
        messageToEncode = messageToEncode.replaceAll("\\p{Punct}", "")
                .replaceAll("\\d", "")
                .toLowerCase()
                .trim()
                .replaceAll(" +", " ");

        for (int m = 0; m < messageToEncode.length(); m++) {
            char c = (char) messageToEncode.charAt(m);
            int idx = getIndexForChar(c);

            freqTable[idx]++;
        }
    }

    public void displayFrequencyTable() {
        for (int i = 0; i < 27; i++) {
            if (freqTable[i] != 0) {
                System.out.printf("[ CHAR: %c | FREQ: %d]\n", getCharForIndex(i), freqTable[i]);
            }
        }
    }

    // public Tree decodeMessage() {

    // }
}
