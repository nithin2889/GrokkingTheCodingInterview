package cp.binaryexponentiation;

public class PowerGeneration {

  public static void main(String[] args) {
    long base = 16, power = 3;
    System.out.println("Power(" + base + '^' + power + ") is: " + power(base, power));
  }

  private static long power(long base, long power) {
    long ans = 1;
    while (power > 0) {
      if (power % 2 == 0) {
        base = base * base;
        power = power / 2;
      } else {
        ans = ans * base;
        power = power - 1;
      }
    }
    return ans;
  }
}
