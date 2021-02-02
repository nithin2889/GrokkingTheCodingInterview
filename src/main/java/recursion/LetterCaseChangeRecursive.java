package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseChangeRecursive {

  public static void main(String[] args) {
    String ip = "a1B2";
    String op = "";
    List<String> output = new ArrayList<>();
    List<String> result = solve(ip, op, output);
    result.forEach(System.out::println);
  }

  /**
   * Using Input-Output method
   */
  public static List<String> solve(String ip, String op, List<String> result) {
    if (ip.isEmpty()) {
      result.add(op);
      return result;
    }
    String op1 = op, op2 = op;
    if (Character.isDigit(ip.charAt(0))) {
      op += ip.charAt(0);
      ip = ip.substring(1);
      solve(ip, op, result);
    } else {
      op1 += ip.toLowerCase().charAt(0);
      op2 += ip.toUpperCase().charAt(0);
      ip = ip.substring(1);
      solve(ip, op1, result);
      solve(ip, op2, result);
    }
    return result;
  }
}
