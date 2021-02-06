package dynamicprogramming.countofsubsetsum;

public class CountOfSubsetSumRecursion {

  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 6, 7, 8, 10, };
    int sum = 10, count = 0;
    int n = arr.length;

    System.out.println("Number of subset matching the sum are: "
        + countSubset(arr, sum, n, count));
  }

  public static int countSubset(int[] arr, int sum, int n, int count) {
    if (n == 0 && sum != 0) {
      return 0;
    }

    if (sum == 0) {
      return 1;
    }

    if (arr[n - 1] <= sum) {
      count += countSubset(arr, sum - arr[n - 1], n - 1, count) +
          countSubset(arr, sum, n - 1, count);
    } else {
      count += countSubset(arr, sum, n - 1, count);
    }
    return count;
  }
}
