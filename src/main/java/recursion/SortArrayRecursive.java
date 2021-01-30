package recursion;

import java.util.ArrayList;
import java.util.List;

public class SortArrayRecursive {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(0);
    list.add(5);
    list.add(2);

    System.out.println("Array before sorting:");
    for (Integer i : list) {
      System.out.print(i + " ");
    }

    System.out.println("\nArray after sorting:");
    List<Integer> sorted = sortArray(list);
    for (Integer s : sorted) {
      System.out.print(s + " ");
    }
  }

  private static List<Integer> sortArray(List<Integer> list) {
    // Base condition
    if (list.size() == 1) {
      return list;
    }
    int temp = list.get(list.size() - 1);
    list.remove(list.size() - 1);

    // Hypotheses
    sortArray(list);

    // Induction
    return insertAt(list, temp);
  }

  private static List<Integer> insertAt(List<Integer> list, int key) {
    // Base condition
    if (list.size() == 0 || list.get(list.size() - 1) <= key) {
      list.add(key);
      return list;
    }

    int lastEl = list.get(list.size() - 1);
    list.remove(list.size() - 1);

    // Hypotheses
    insertAt(list, key);

    // Induction
    list.add(lastEl);
    return list;
  }
}
