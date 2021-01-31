package recursion;

public class TowerOfHanoiRecursive {

  public static void main(String[] args) {
    int ctr = 0;
    String src = "A", hlp = "B", dst = "C";

    move(3, src, hlp, dst, ctr);
  }

  public static void move(int numOfDisks, String src, String hlp, String dst, int noOfSteps) {
    noOfSteps++;
    // base condition
    if (numOfDisks == 1) {
      print(numOfDisks, src, hlp, dst);
      return;
    }
    // hypothesis
    move(numOfDisks - 1, src, dst, hlp, noOfSteps);
    // induction
    print(numOfDisks, src, hlp, dst);
    move(numOfDisks - 1, hlp, src, dst, noOfSteps);
  }

  public static void print(int numOfDisks, String src, String hlp, String dst) {
    System.out
        .println(
            "Moving " + numOfDisks + " disk from " + src + " to " + dst + " using " + hlp);
  }
}
