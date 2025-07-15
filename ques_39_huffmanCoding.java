import java.util.Comparator;
import java.util.PriorityQueue;

public class ques_39_huffmanCoding {
  static class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

    public static void printCodes(HuffmanNode root, String code) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            System.out.println(root.ch + ": " + code);
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freqs = {5, 9, 12, 13, 16, 45};

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));
        for (int i = 0; i < chars.length; i++)
            pq.add(new HuffmanNode(chars[i], freqs[i]));

        while (pq.size() > 1) {
            HuffmanNode a = pq.poll();
            HuffmanNode b = pq.poll();
            HuffmanNode merged = new HuffmanNode('-', a.freq + b.freq);
            merged.left = a;
            merged.right = b;
            pq.add(merged);
        }

        HuffmanNode root = pq.poll();
        printCodes(root, "");
    }
}
