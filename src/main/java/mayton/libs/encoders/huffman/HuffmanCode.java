package mayton.libs.encoders.huffman;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode {

    public static HuffmanTree buildTree(Map<String, Integer> stringFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        for(Map.Entry<String,Integer> entry : stringFreqs.entrySet()) {
            if (entry.getValue() > 0) {
                trees.offer(new HuffmanStringLeaf(entry.getValue(), entry.getKey()));
            }
        }
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    // input is an array of frequencies, indexed by character code
    public static HuffmanTree buildTree(int[] charFreqs) {

        PriorityQueue<HuffmanTree> trees = new PriorityQueue<>();
        // initially, we have a forest of leaves
        // one for each non-empty character
        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0) {
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));
            }
        }

        assert trees.size() > 0;
        // loop until there is only one tree left
        while (trees.size() > 1) {
            // two trees with least frequency
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            // put into new node and re-insert into queue
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(@NotNull HuffmanTree tree, StringBuilder prefix) {

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            // print out character, frequency, and code for this leaf (which is just the prefix)
            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            // traverse left
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);

            // traverse right
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void main(String[] args) {
        String test = "this is an 111 example for huffman encoding привед медвед ддддддд 1111111111111111111111111111111111";

        // we will assume that all our characters will have
        // code less than 256, for simplicity
        int[] charFreqs = new int[65536];
        // read each character and record the frequencies
        for (char c : test.toCharArray()) {
            charFreqs[(int) c]++;
        }

        // build tree
        HuffmanTree tree = buildTree(charFreqs);

        // print out results
        System.out.println("SYMBOL\tWEIGHT\tHUFFMAN CODE");
        printCodes(tree, new StringBuilder());
    }
}
