package dynamicprogramming.dpfortrees;

public class MaxPathSumFromAnyNodeToAnyNode {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    int res = Integer.MIN_VALUE;
    System.out.println("The maximum path sum of the tree is: "
        + maxPathSum(root, res));
  }

  private static int maxPathSum(Node root, int res) {
    if (root == null) {
      return 0;
    }
    int leftMaxPathSum = maxPathSum(root.left, res);
    int rightMaxPathSum = maxPathSum(root.right, res);

    int tempAns = Math.max(Math.max(leftMaxPathSum, rightMaxPathSum) + root.val, root.val);
    int ans = leftMaxPathSum + rightMaxPathSum + root.val;
    res = Math.max(res, ans);
    return res;
  }

  static class Node {

    int val;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
      this.val = val;
    }

    Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
