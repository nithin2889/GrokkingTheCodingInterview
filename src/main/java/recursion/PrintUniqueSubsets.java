package recursion;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueSubsets {

  public static void main(String[] args) {
    Set<String> uniqueSubset = new HashSet<>();
    uniqueSubset = printUnique("aab", "", uniqueSubset);
    System.out.println("Unique subsets: ");
    uniqueSubset.forEach(System.out::println);
  }

  public static Set<String> printUnique(String ipStr, String opStr,
      Set<String> resMap) {
    if (ipStr.isEmpty()) {
      resMap.add(opStr);
      return new HashSet<>();
    }
    String opStr2 = opStr;

    opStr2 += ipStr.charAt(0);
    ipStr = ipStr.substring(1);

    printUnique(ipStr, opStr, resMap);
    printUnique(ipStr, opStr2, resMap);

    return resMap;
  }
}
