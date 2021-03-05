package stack;

public class RainWaterTrapping {

  public static void main(String[] args) {
    int[] arr = {3, 0, 0, 2, 0, 4};
    int size = arr.length;

    int[] maxL = new int[size];
    maxL[0] = arr[0];

    int[] maxR = new int[size];
    maxR[size - 1] = arr[size - 1];

    int sum = amountOfRainWaterTrapped(arr, size, maxL, maxR);
    System.out.println("Maximum water that can be trapped is: " + sum);
  }

  private static int amountOfRainWaterTrapped(int[] arr, int size, int[] maxL, int[] maxR) {
    // max element to the left of the current element
    for (int i = 1; i < size; i++) {
      maxL[i] = Math.max(maxL[i - 1], arr[i]);
    }

    // max element to the right of the current element
    for (int i = size - 2; i >= 0; i--) {
      maxR[i] = Math.max(maxR[i + 1], arr[i]);
    }

    int[] water = new int[size];
    // subtracting the building height from the min element from the
    // left and the right element of the array
    for (int i = 0; i < size; i++) {
      water[i] = Math.min(maxL[i], maxR[i]) - arr[i];
    }

    // Finally, adding heights of the water
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += water[i];
    }
    return sum;
  }
}
