package leet.code.solution;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static java.util.Collections.emptySet;

public class BSTTwoSum {

    public static long twoSum(BinarySearchTree.Node root1, BinarySearchTree.Node root2, int value) {

        final Set<Integer> set1 = printBFS(root1);
        if (set1.isEmpty()) {
            return 0;
        }

        final Set<Integer> set2 = printBFS(root2);
        if (set2.isEmpty()) {
            return 0;
        }

        final long count = set1.stream()
                .map(e -> value - e)
                .filter(e -> {
                    if (set2.contains(e)) {
                        set2.remove(e);
                        return true;
                    }
                    return false;
                }).count();

        return count;

    }

    @SuppressWarnings("Duplicates")
    private static Set<Integer> printBFS(BinarySearchTree.Node head) {
        if (head == null) {
            return emptySet();
        }

        Set<Integer> set = new HashSet<>();

        Queue<BinarySearchTree.Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            BinarySearchTree.Node node = queue.poll();
            set.add(node.getValue());

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

        return set;
    }

    public static void main(String[] args) {

        // formation of BST 1
        final BinarySearchTree root1 = new BinarySearchTree();

        root1.addNode(5);
        root1.addNode(3);
        root1.addNode(7);
        root1.addNode(2);
        root1.addNode(4);
        root1.addNode(6);
        root1.addNode(8);

        // formation of BST 2
        final BinarySearchTree root2 = new BinarySearchTree();

        root2.addNode(10);
        root2.addNode(6);
        root2.addNode(15);
        root2.addNode(3);
        root2.addNode(8);
        root2.addNode(11);
        root2.addNode(18);

        System.out.println(twoSum(root1.getHead(), root2.getHead(), 16));
    }


}
