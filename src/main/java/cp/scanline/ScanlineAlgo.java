package cp.scanline;

public class ScanlineAlgo {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 5, 2, 3, 2};
    System.out.println("Brute force to get the modified array: ");
    solveBruteForce(arr, 0, 2, 3);

    arr = new int[]{5, 1, 2, 3, 4};
    System.out.println("\nOptimized solution to get the modified array: ");
    solveUsingScanLine(arr, 0, 4, 2);
  }

  private static void solveBruteForce(int[] arr, int l, int r, int x) {
    for (int i = l; i <= r; i++) {
      arr[i] += x;
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static void solveUsingScanLine(int[] arr, int l, int r, int x) {
    // create a prefixSum array of length one more than the given array
    int[] prefixSum = new int[arr.length + 1];

    // add x to array position l and subtract x from array position r + 1
    prefixSum[l] += x;
    prefixSum[r + 1] -= x;

    int scan = 0;
    // add prefixSum array contents to scan and in turn add scan to the given array
    for (int i = 0; i < prefixSum.length; i++) {
      scan += prefixSum[i];
      arr[i] += scan;
    }

    // finally print the modified array
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
  }
}
