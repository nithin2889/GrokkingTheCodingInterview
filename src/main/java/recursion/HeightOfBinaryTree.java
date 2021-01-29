package recursion;

public class HeightOfBinaryTree {

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }

    int left = height(root.left);
    int right = height(root.right);

    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode();
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(5);

    System.out.println("Height of the binary tree is: " +
        HeightOfBinaryTree.height(tree.root));
  }
}
