package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal589 {

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

    public List<Integer> preorder(Node root) {
        dfs(root);
        return result;
    }

    /**
     * 递归
     *
     * @param root
     */
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }

    /**
     * 迭代
     *
     * @param root
     */
    private void bfs(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.add(node.children.get(i));
                }
            }
        }
    }
}
