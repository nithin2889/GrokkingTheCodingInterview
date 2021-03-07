package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: "
        + LongestSubstringKDistinct.findLength("araaci", 2));

    System.out.println("Length of the longest substring: "
        + LongestSubstringKDistinct.findLength("araaci", 1));

    System.out.println("Length of the longest substring: "
        + LongestSubstringKDistinct.findLength("cbbebi", 3));
  }

  /**
   * Given a string, find the length of the longest substring in it
   * with no more than K distinct characters.
   *
   * Input: String="araaci", K=2
   * Output: 4
   * Explanation: The longest substring with no more than '2'
   * distinct characters is "araa".
   *
   * Solution:
   * This problem follows the Sliding Window pattern, and we can use a
   * similar dynamic sliding window strategy as discussed in Smallest Subarray
   * with a given sum. We can use a HashMap to remember the frequency of each
   * character we have processed. Here is how we will solve this problem:
   *
   * 1. First, we will insert characters from the beginning of the string until
   * we have ‘K’ distinct characters in the HashMap.
   *
   * 2. These characters will constitute our sliding window. We are asked to find
   * the longest such window having no more than ‘K’ distinct characters. We will
   * remember the length of this window as the longest window so far.
   *
   * 3. After this, we will keep adding one character in the sliding window
   * (i.e., slide the window ahead) in a stepwise fashion.
   *
   * 4. In each step, we will try to shrink the window from the beginning if the
   * count of distinct characters in the HashMap is larger than ‘K.’ We will shrink
   * the window until we have no more than ‘K’ distinct characters in the HashMap.
   * This is needed as we intend to find the longest window.
   *
   * 5. While shrinking, we’ll decrement the character’s frequency going out of the
   * window and remove it from the HashMap if its frequency becomes zero.
   *
   * 6. At the end of each step, we’ll check if the current window length is the
   * longest so far, and if so, remember its length.
   *
   * Time Complexity:
   * The above algorithm’s time complexity will be O(N),
   * where ‘N’ is the number of characters in the input string.
   *
   * The outer for loop runs for all characters, and the inner while loop
   * processes each character only once; therefore, the time complexity
   * of the algorithm will be O(N+N), which is asymptotically equivalent to O(N).
   *
   * Space Complexity:
   * The algorithm’s space complexity is O(K), as we will be storing a maximum of
   * 'K+1' characters in the HashMap.
   */
  public static int findLength(String str, int k) {
    if(str == null || str.length() == 0 || str.length() < k) {
      throw new IllegalArgumentException();
    }

    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();

    // in this for loop, we look to extend the range [windowStart, windowEnd]
    for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

      // shrinking the sliding window until we are left with 'k' distinct characters in the frequency map.
      while(charFrequencyMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);

        // remove from the frequency map if the number of occurrences become '0'
        if(charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++; // shrinks the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maxLength so far
    }
    return maxLength;
  }
}
