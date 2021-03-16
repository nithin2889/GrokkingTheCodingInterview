package cp.slidingwindow;

public class NastyaAndDoorCF1341B {

  public static void main(String[] args) {
    int n = 8;
    int[] arr = {1, 2, 4, 1, 2, 4, 1, 2};
    int k = 3;

    System.out.println(findPeakAndStartIndex(arr, n, k));
  }

  private static String findPeakAndStartIndex(int[] arr, int n, int k) {
    int peaks = 0, idx = 0;

    // first subarray check for peaks
    for (int i = 1; i < k; i++) {
      if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
        peaks++;
      }
    }
    int max = peaks;
    int l = 0, r = k - 1;

    while (r < n - 1) {
      // transition for the r pointer
      if (arr[r] > arr[r - 1] && arr[r] > arr[r + 1]) {
        peaks++;
        r++;
      }

      // transition for the l pointer
      l++;
      if (arr[l] > arr[l - 1] && arr[l] > arr[l + 1]) {
        peaks--;
      }

      if (peaks > max) {
        max = peaks;
        idx = l;
      }
    }
    return max + 1 + " " + idx + 1;
  }
}
