package recursion;

public class KthGrammarSymbol {

  public static void main(String[] args) {
    System.out.println("Grammar at Nth row and Kth index: " + solveKthGrammar(4, 5));
  }

  public static int solveKthGrammar(int N, int K) {
    // Base Condition
    if (N == 1 && K == 1) {
      return 0;
    }

    double length = Math.pow(2, N - 1);
    int mid = (int) length / 2;

    // Hypothesis
    if (K <= mid) {
      return solveKthGrammar(N - 1, K);
    } else {
      // Induction
      if (solveKthGrammar(N - 1, K - mid) == 0) {
        return 1;
      } else {
        return 0;
      }
    }
  }
}
