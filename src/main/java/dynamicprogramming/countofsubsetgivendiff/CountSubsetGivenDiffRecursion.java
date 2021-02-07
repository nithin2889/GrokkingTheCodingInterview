package dynamicprogramming.countofsubsetgivendiff;

public class CountSubsetGivenDiffRecursion {

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 3};
    int diff = 1, s1;
    int totalSum = 0, count = 0;
    int n = arr.length;

    for (int i : arr) {
      totalSum += i;
    }

    s1 = diff + totalSum / 2;
    System.out.println("Number of subset matching the sum are: "
        + countSubset(arr, s1, n, count));
  }

  private static int countSubset(int[] arr, int s1, int n, int count) {
    if (n == 0 && s1 != 0) {
      return 0;
    }
    if (s1 == 0) {
      return 1;
    }

    if (arr[n - 1] <= s1) {
      count += countSubset(arr, s1 - arr[n - 1], n - 1, count) +
          countSubset(arr, s1, n - 1, count);
    } else {
      count += countSubset(arr, s1, n - 1, count);
    }
    return count;
  }
}
