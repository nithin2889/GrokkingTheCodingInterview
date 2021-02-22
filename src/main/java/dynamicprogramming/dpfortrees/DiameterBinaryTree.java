package dynamicprogramming.dpfortrees;

public class DiameterBinaryTree {

  public static void main(String[] args) {
    Node root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);

    int res = Integer.MIN_VALUE;
    System.out.println("The diameter of the given tree is: "
        + diameter(root, res));
  }

  private static int diameter(Node root, int res) {
    if (root == null) {
      return 0;
    }
    // calculate diameter for both right and the left subtrees.
    int leftDia = diameter(root.left, res);
    int rightDia = diameter(root.right, res);

    // consider root and the one with the maximum diameter
    // from either the right or the left subtree.
    int tempAns = Math.max(leftDia, rightDia) + 1;
    // consider the whole subtree.
    int ans = 1 + leftDia + rightDia;
    // consider the best between the whole subtree and the res
    res = Math.max(res, ans);

    return tempAns;
  }

  static Node newNode(int data) {
    Node node = new Node();
    node.data = data;
    node.left = null;
    node.right = null;

    return (node);
  }

  /* Tree node structure used in the program */
  static class Node {

    int data;
    Node left, right;
  }
}
