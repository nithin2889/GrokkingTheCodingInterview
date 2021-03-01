package binarysearch;

public class NextAlphabeticalElement {

  public static void main(String[] args) {
    char[] arr = {'a', 'c', 'f', 'h'};
    char ele = 'f';
    System.out.println("Next alphabetical element after " + ele + " is: " + findNextChar(arr, ele));
  }

  private static char findNextChar(char[] arr, char ele) {
    int start = 0, end = arr.length - 1;
    char res = '0';

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (arr[mid] == ele) {
        start = mid + 1;
      } else if (arr[mid] < ele) {
        start = mid + 1;
      } else {
        res = arr[mid];
        end = mid - 1;
      }
    }
    return res;
  }
}
