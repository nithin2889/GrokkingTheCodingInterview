package dynamicprogramming.scrambledstringrecursive;

public class ScrambledStringRecursive {

  public static void main(String[] args) {
    String a = "great", b = "grate";
    System.out.println("Are the two strings scrambled? " + solve(a, b));
  }

  private static boolean solve(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    if (a.compareTo(b) == 0) {
      return true;
    }
    if (a.length() == 0) {
      return false;
    }
    int length = a.length();
    boolean isScrambled = false;
    for (int i = 1; i < length; i++) {
      if ((solve(a.substring(0, i), b.substring(length - i))
          && solve(a.substring(i, length), b.substring(0, length - i)))
          || (solve(a.substring(0, i), b.substring(0, i))
          && solve(a.substring(i, length), b.substring(i, length)))) {
        isScrambled = true;
        break;
      }
    }
    return isScrambled;
  }
}
