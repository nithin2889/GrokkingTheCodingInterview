package recursion;

public class PrintNumbers {

  public static void main(String[] args) {
    printFrom1ToN(7);
    System.out.println();
    printFromNTo1(7);
  }

  public static void printFrom1ToN(int n) {
    // base condition
    if (n == 0) {
      return;
    }

    // hypotheses
    printFrom1ToN(n - 1);

    // induction
    System.out.print(n + " ");
  }

  public static void printFromNTo1(int n) {
    // base condition
    if (n == 0) {
      return;
    }

    // induction
    System.out.print(n + " ");

    // hypotheses
    printFromNTo1(n - 1);
  }
}
