package dynamicprogramming.palindromepartitioning;

public class PalindromePartitioningRecursive {

  public static void main(String[] args) {
    String inStr = "nitin";
    int n = inStr.length();
    int i = 0, j = n - 1;
    System.out.println("Min number of partitions in the string is: "
        + minPartitions(inStr, i, j));
  }

  private static int minPartitions(String s, int i, int j) {
    if (i >= j) {
      return 0;
    }
    if (isPalindrome(s)) {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    for (int k = i; k <= j - 1; k++) {
      int tempAns = minPartitions(s, i, k) + minPartitions(s, k + 1, j) + 1;
      ans = Math.min(ans, tempAns);
    }
    return ans;
  }

  private static boolean isPalindrome(String s) {
    int n = s.length();
    for (int i = 0; i < (n / 2); i++) {
      if (s.charAt(i) != s.charAt(n - i - 1)) {
        return false;
      }
    }
    return true;
  }
}
