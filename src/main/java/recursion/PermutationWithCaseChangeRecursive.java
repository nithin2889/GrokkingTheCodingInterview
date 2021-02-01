package recursion;

public class PermutationWithCaseChangeRecursive {

  public static void main(String[] args) {
    String ip = "ab", op = "";
    solve(ip, op);
  }

  public static void solve(String ip, String op) {
    if (ip.isEmpty()) {
      System.out.println(op);
      return;
    }
    String op1 = op, op2 = op;
    op1 += ip.charAt(0);
    op2 += ip.toUpperCase().charAt(0);
    ip = ip.substring(1);

    solve(ip, op1);
    solve(ip, op2);
  }
}
