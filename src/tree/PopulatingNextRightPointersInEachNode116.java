package tree;

/**
 * TODO
 *
 * @author Terry
 * @since 2020/12/3 17:06
 */
public class PopulatingNextRightPointersInEachNode116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}

        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        connectTwoNode(root.left,root.right);
        return root;
    }

    private void connectTwoNode(Node leftNode,Node rightNode){
       if (leftNode == null || rightNode == null) {
           return;
       }
       leftNode.next = rightNode;
       connectTwoNode(leftNode.left,leftNode.right);
       connectTwoNode(leftNode.right,rightNode.left);
       connectTwoNode(rightNode.left,rightNode.right);
    }

}
