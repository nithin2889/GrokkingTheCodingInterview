package stack;

import java.util.Comparator;

public class Pair implements Comparator<Pair> {

  int key;
  int value;

  Pair() {
  }

  Pair(int key, int value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public int compare(Pair a, Pair b) {
    if (a.value == b.value) {
      return 0;
    } else if (a.value < b.value) {
      return 1;
    } else {
      return -1;
    }
  }

  @Override
  public String toString() {
    return String.valueOf(key);
  }
}
