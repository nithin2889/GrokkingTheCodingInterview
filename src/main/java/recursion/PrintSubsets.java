package recursion;

public class PrintSubsets {

  public static void main(String[] args) {
    System.out.println("Printing all subsets including empty string: ");
    print("ab", "");
  }

  public static void print(String ipStr, String opStr) {
    if (ipStr.isEmpty()) {
      System.out.println(opStr);
      return;
    }
    String opStr2 = opStr;

    opStr2 += ipStr.charAt(0);
    ipStr = ipStr.substring(1);

    print(ipStr, opStr);
    print(ipStr, opStr2);
  }
}
