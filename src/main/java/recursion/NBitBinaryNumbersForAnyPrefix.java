package recursion;

import java.util.ArrayList;
import java.util.List;

public class NBitBinaryNumbersForAnyPrefix {

  public static void main(String[] args) {
    int N = 4;
    int ones = 0, zeroes = 0;
    String op = "";
    List<String> output = new ArrayList<>();
    List<String> result = print(N, ones, zeroes, op, output);
    result.forEach(System.out::println);
  }

  public static List<String> print(int N, int ones, int zeroes, String op, List<String> output) {
    if (N == 0) {
      output.add(op);
      return output;
    }
    String op1 = op, op2;

    // As per the recursive tree, 1 is available always. Hence it is not in any condition.
    op1 += "1";
    print(N - 1, ones + 1, zeroes, op1, output);

    // As per the recursive tree, only when 1's is greater than 0's  we add a 0.
    if (ones > zeroes) {
      op2 = op;
      op2 += "0";
      print(N - 1, ones, zeroes + 1, op2, output);
    }
    return output;
  }
}
