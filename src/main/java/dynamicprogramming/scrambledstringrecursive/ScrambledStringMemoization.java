package dynamicprogramming.scrambledstringrecursive;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMemoization {

  public static void main(String[] args) {
    String a = "great", b = "grate";
    Map<String, Boolean> map = new HashMap<>();
    System.out.println("Are the two strings scrambled? " + solve(a, b, map));
  }

  private static boolean solve(String a, String b, Map<String, Boolean> map) {
    if (a.length() != b.length()) {
      return false;
    }
    if (a.compareTo(b) == 0) {
      return true;
    }
    if (a.length() == 0) {
      return false;
    }

    String key = a + " " + b;
    // Search in the map before calling the recursive functions again.
    if (map.containsKey(key)) {
      return map.get(key);
    }
    int length = a.length();
    boolean isScrambled = false;
    for (int i = 1; i < length; i++) {
      if ((solve(a.substring(0, i), b.substring(length - i), map)
          && solve(a.substring(i, length), b.substring(0, length - i), map))
          || (solve(a.substring(0, i), b.substring(0, i), map)
          && solve(a.substring(i, length), b.substring(i, length), map))) {
        isScrambled = true;
        break;
      }
    }
    map.put(a + " " + b, isScrambled);
    return isScrambled;
  }
}
