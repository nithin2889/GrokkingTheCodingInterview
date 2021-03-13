package cp.scanline;

public class ScanlineAlgo {

  public static void main(String[] args) {
    int[] arr = {1, 5, 2, 3, 2};
    System.out.println("Brute force to get the modified array: ");
    solveBruteForce(arr, 0, 2, 3);
  }

  private static void solveBruteForce(int[] arr, int l, int r, int x) {
    for (int i = l; i <= r; i++) {
      arr[i] += x;
    }

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
