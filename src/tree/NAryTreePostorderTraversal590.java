package tree;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NAryTreePostorderTraversal590 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> result = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return result;
    }

    /**
     * dfs
     *
     * @param root
     */
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                dfs(child);
            }
        }
        result.add(root.val);
    }


    private void bfs(Node root) {
        if (root == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            Node node = deque.pop();
            result.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    deque.push(child);
                }
            }
        }
        Collections.reverse(result);
    }
}
