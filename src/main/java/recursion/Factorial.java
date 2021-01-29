package recursion;

public class Factorial {

  public static void main(String[] args) {
    System.out.println(Factorial.fact(5));
  }

  public static int fact(int n) {
    // base condition
    if (n == 0) {
      return 1;
    }
    // hypotheses
    return n * fact(n - 1);
  }
}
