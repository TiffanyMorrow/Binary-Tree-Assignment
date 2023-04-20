import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class DaileyTree {
    class Node {
        private int val;
        Node left, right, parent;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
            parent = null;
        }

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
            left = null;
            right = null;
        }

        public int getValue() {
            return val;
        }

        public void setValue(int val) {
            this.val = val;
        }

        public void displayValue() {
            System.out.println("Node value: " + val);
        }
    }

    private int depth, level, max;
    Node root, head;
    TreeMap<Integer, Integer> hashy;

    public DaileyTree(int depth) {
        hashy = new TreeMap<>();

        head = new Node(1);
        head.left = new Node(2, head);
        head.right = head.left;

        head.left.left = new Node(3, head.left);
        head.left.right = head.left.left;
        head.right.left = head.left.left;
        head.right.right = head.left.left;
        root = head.left.left;

        this.depth = depth;
        level = 1;
        max = 0;

        if(depth > 1)
            buildTree(root, level);

        calculateMax();
    }

    public void buildTree(Node node, int level) {
        if (level > depth-1)
            return;

        node.left = new Node(node.val + node.parent.parent.val, node);
        node.right = new Node(node.val + node.parent.val, node);

        buildTree(node.left, level+1);
        buildTree(node.right, level+1);
    }

    public void inOrderTraversal(Node node) {
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }

    public void occurrenceTraversal(Node node) {
        if (node == null)
            return;
        occurrenceTraversal(node.left);
        hashy.put(node.val, hashy.get(node.val)+1);
        occurrenceTraversal(node.right);
    }

    public void preOrderTraversal(Node node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void postOrderTraversal(Node node) {
        if (node == null)
            return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

    public void calculateMax(){
        Node trav = root;
        while(trav.right != null)
            trav = trav.right;
        max = trav.val;
    }

    public void findOccurrences(){
        hashy.put(1, 1);
        hashy.put(2, 1);

        for (int i=3; i<=max; i++)
            hashy.put(i, 0);

        occurrenceTraversal(root);

        System.out.print("Missing: ");
        for (Map.Entry<Integer, Integer> val : hashy.entrySet()) {
            if (val.getValue() == 0)
                System.out.print(val.getKey() + " ");
        }
        System.out.println("\nCounts -> ");
        for (Map.Entry<Integer, Integer> val : hashy.entrySet())
            System.out.println(val.getKey() + ": " + val.getValue());
    }
}