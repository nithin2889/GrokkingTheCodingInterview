package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class AnagramOccurances007 {

  public static void main(String[] args) {
    System.out.println("Number of anagrams in the string are: ");
    int count = AnagramOccurances007.countOccurance("aabaabaa", "aa");
    System.out.println(count);
  }

  public static int countOccurance(String str, String pattern) {
    int k = pattern.length();

    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    int count = 0;
    int i = 0, j = 0;
    int anagramCount = 0;

    for(int m = 0; m < k; m++) {
      char ch = pattern.charAt(m);
      charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);
    }
    count = charFrequencyMap.size();

    while(j < str.length()) {
      char sc = str.charAt(j);
      if (charFrequencyMap.containsKey(sc)) {
        charFrequencyMap.put(sc, charFrequencyMap.get(sc) - 1);

        if(charFrequencyMap.get(sc) == 0) {
          count--;
        }
      }

      if(j-i+1 < k) {
        j++;
      } else if(j-i+1 == k) {
        if(count == 0) {
          anagramCount++;
        }

        if(charFrequencyMap.containsKey(str.charAt(i))) {
          charFrequencyMap.put(str.charAt(i), charFrequencyMap.get(str.charAt(i)) + 1);

          if(charFrequencyMap.get(str.charAt(i)) == 1) {
            count++;
          }
        }
        i++;
        j++;
      }
    }
    return anagramCount;
  }
}
